package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.TopoDumpDto;
import com.example.netisbackend.dto.topology.TopoRestHistDto;
import com.example.netisbackend.mapper.topology.DumpMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class DumpService {

    private final DumpMapper dumpMapper;

    // ==================== Export ====================

    public byte[] exportTopology(String userId) {
        try {
            DOMSource xmlDOM = createDOMSource(userId);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(baos);
            TransformerFactory.newInstance().newTransformer().transform(xmlDOM, result);
            return baos.toByteArray();
        } catch (Exception e) {
            log.error("exportTopology XML 생성 실패", e);
            throw new RuntimeException("토폴로지 내보내기 중 오류가 발생하였습니다.", e);
        }
    }

    // ==================== Import ====================

    @Transactional
    public void importTopology(String userId, byte[] xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            Document doc = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xmlData));

            // auth 검증 (userId 평문 일치 확인)
            List<Map<String, Object>> authList = getNodeData(doc.getElementsByTagName("auth"));
            if (CollectionUtils.isEmpty(authList)) {
                throw new RuntimeException("인증정보가 존재하지 않습니다.");
            }
            Map<String, Object> authMap = authList.get(0);
            String xmlUserId = (String) authMap.get("userId");
            if (!userId.equals(xmlUserId)) {
                throw new RuntimeException("인증정보가 유효하지 않습니다.");
            }

            // 토폴로지 삭제
            dumpMapper.deleteTopology(userId);

            // XML에서 데이터 파싱
            List<Map<String, Object>> groupList = getNodeData(doc.getElementsByTagName("group"));
            List<Map<String, Object>> itemList = getNodeData(doc.getElementsByTagName("item"));
            List<Map<String, Object>> etcList = getNodeData(doc.getElementsByTagName("etc"));
            List<Map<String, Object>> linkList = getNodeData(doc.getElementsByTagName("link"));
            List<Map<String, Object>> linkMultiList = getNodeData(doc.getElementsByTagName("linkMulti"));
            List<Map<String, Object>> userList = getNodeData(doc.getElementsByTagName("user"));
            List<Map<String, Object>> drawToolList = getNodeData(doc.getElementsByTagName("drawTool"));

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("userId", userId);
            paramMap.put("groupList", groupList);
            paramMap.put("itemList", itemList);
            paramMap.put("etcList", etcList);
            paramMap.put("linkList", linkList);
            paramMap.put("linkMultiList", linkMultiList);
            paramMap.put("userList", userList);
            paramMap.put("drawToolList", drawToolList);

            if (!CollectionUtils.isEmpty(groupList)) dumpMapper.insertGroup(paramMap);
            if (!CollectionUtils.isEmpty(itemList)) dumpMapper.insertItem(paramMap);
            if (!CollectionUtils.isEmpty(etcList)) dumpMapper.insertEtc(paramMap);
            if (!CollectionUtils.isEmpty(linkList)) dumpMapper.insertLink(paramMap);
            if (!CollectionUtils.isEmpty(linkMultiList)) dumpMapper.insertLinkMulti(paramMap);
            if (!CollectionUtils.isEmpty(userList)) dumpMapper.insertUser(paramMap);
            if (!CollectionUtils.isEmpty(drawToolList)) dumpMapper.insertDrawTool(paramMap);

            dumpMapper.procSpMakeTopoLeaf(userId);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            log.error("importTopology XML 파싱 실패", e);
            throw new RuntimeException("토폴로지 가져오기 중 오류가 발생하였습니다.", e);
        }
    }

    // ==================== Dump History ====================

    public List<TopoDumpDto> getDumpList(String userId) {
        return dumpMapper.selectDumpList(userId);
    }

    @Transactional
    public void addDump(String userId, Long grpNo, String memo) {
        generateDump(userId, memo);
    }

    @Transactional
    public void addDumpBySystem(String userId, Long grpNo, String memo) {
        generateDump(userId, memo);
    }

    private void generateDump(String userId, String memo) {
        byte[] xmlBytes = exportTopology(userId);

        Map<String, Object> histMap = new HashMap<>();
        histMap.put("userId", userId);
        histMap.put("xmlText", xmlBytes);
        histMap.put("memo", memo);
        dumpMapper.insertDumpXML(histMap);
    }

    // ==================== Restore from Dump ====================

    @Transactional
    public void restoreFromDump(String userId, long dumpSeq, String sessUserIp) {
        Map<String, Object> dumpData = dumpMapper.selectDumpXML(dumpSeq);
        if (dumpData == null || dumpData.get("xmlText") == null) {
            throw new RuntimeException("덤프 데이터가 존재하지 않습니다.");
        }

        byte[] xmlBytes = (byte[]) dumpData.get("xmlText");
        importTopology(userId, xmlBytes);

        // Insert restore history
        Map<String, Object> histMap = new HashMap<>();
        histMap.put("dumpSeq", dumpSeq);
        histMap.put("userId", userId);
        histMap.put("sessUserIp", sessUserIp);
        dumpMapper.insertRestoreHist(histMap);
    }

    // ==================== Restore History ====================

    public List<TopoRestHistDto> getRestoreHist(Map<String, Object> params) {
        return dumpMapper.selectRestoreHist(params);
    }

    // ==================== Delete Dump ====================

    @Transactional
    public void deleteDump(long dumpSeq) {
        dumpMapper.deleteDump(dumpSeq);
    }

    // ==================== XML Helper Methods ====================

    private DOMSource createDOMSource(String userId) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Node root = doc.createElement("topology");
        doc.appendChild(root);

        // auth element (version, userId 평문, createTime)
        Element auth = doc.createElement("auth");
        root.appendChild(auth);
        {
            Element version = doc.createElement("version");
            version.appendChild(doc.createTextNode("5.2"));
            auth.appendChild(version);
        }
        {
            Element userIdElem = doc.createElement("userId");
            userIdElem.appendChild(doc.createTextNode(userId));
            auth.appendChild(userIdElem);
        }
        {
            Element createTime = doc.createElement("createTime");
            createTime.appendChild(doc.createTextNode(
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))));
            auth.appendChild(createTime);
        }

        // groupList
        List<Map<String, Object>> gList = dumpMapper.selectGroupAll(userId);
        Element group = doc.createElement("groupList");
        root.appendChild(group);
        appendChildData(doc, gList, group, "group");

        // itemList
        List<Map<String, Object>> iList = dumpMapper.selectItemAll(userId);
        Element item = doc.createElement("itemList");
        root.appendChild(item);
        appendChildData(doc, iList, item, "item");

        // etcList
        List<Map<String, Object>> eList = dumpMapper.selectEtcAll(userId);
        Element etc = doc.createElement("etcList");
        root.appendChild(etc);
        appendChildData(doc, eList, etc, "etc");

        // linkList
        List<Map<String, Object>> lList = dumpMapper.selectLinkAll(userId);
        Element link = doc.createElement("linkList");
        root.appendChild(link);
        appendChildData(doc, lList, link, "link");

        // linkMultiList
        List<Map<String, Object>> lmList = dumpMapper.selectLinkMultiAll(userId);
        Element linkMulti = doc.createElement("linkMultiList");
        root.appendChild(linkMulti);
        appendChildData(doc, lmList, linkMulti, "linkMulti");

        // userList
        List<Map<String, Object>> uList = dumpMapper.selectUserAll(userId);
        Element user = doc.createElement("userList");
        root.appendChild(user);
        appendChildData(doc, uList, user, "user");

        // drawToolList
        List<Map<String, Object>> dtList = dumpMapper.selectDrawToolAll(userId);
        Element drawTool = doc.createElement("drawToolList");
        root.appendChild(drawTool);
        appendChildData(doc, dtList, drawTool, "drawTool");

        return new DOMSource(doc);
    }

    private void appendChildData(Document doc, List<Map<String, Object>> list, Element parentElement, String tagName) {
        for (Map<String, Object> dataMap : list) {
            Element element = doc.createElement(tagName);
            for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
                Element e = doc.createElement(entry.getKey());
                e.appendChild(doc.createTextNode(String.valueOf(entry.getValue())));
                element.appendChild(e);
            }
            parentElement.appendChild(element);
        }
    }

    private List<Map<String, Object>> getNodeData(NodeList nList) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        if (nList != null && nList.getLength() > 0) {
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Map<String, Object> map = new HashMap<>();
                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            String content = childNode.getTextContent();
                            map.put(childNode.getNodeName(),
                                    (content == null || content.isEmpty() || "null".equals(content)) ? null : content);
                        }
                    }
                    if (!map.isEmpty()) {
                        dataList.add(map);
                    }
                }
            }
        }
        return dataList;
    }
}
