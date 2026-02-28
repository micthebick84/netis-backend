package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.TopoItemDto;
import com.example.netisbackend.dto.topology.TopoLinkDto;
import com.example.netisbackend.mapper.topology.LineSettingMapper;
import com.example.netisbackend.mapper.topology.PointAddMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LineSettingService {

    private final LineSettingMapper lineSettingMapper;
    private final PointAddMapper pointAddMapper;

    @Transactional
    @SuppressWarnings("unchecked")
    public Map<String, Object> addLine(Map<String, Object> params) {
        List<Map<String, Object>> lineList = (List<Map<String, Object>>) params.get("list");
        List<Long> pointItemNos = new ArrayList<>();

        for (Map<String, Object> lineMap : lineList) {
            lineMap.put("userId", params.get("userId"));
            lineMap.put("grpNo", params.get("grpNo"));
            lineMap.put("itemNo1", params.get("itemNo1"));
            lineMap.put("itemNo2", params.get("itemNo2"));
            lineMap.put("mngNo1", params.get("mngNo1"));
            lineMap.put("mngNo2", params.get("mngNo2"));
            lineMap.put("evtLvlList", params.get("evtLvlList"));
            lineSettingMapper.insertLink(lineMap);

            // point 추가
            String lineType = String.valueOf(lineMap.get("lineType"));
            int pointCnt = 0;
            Object pointCntObj = lineMap.get("pointCnt");
            if (pointCntObj != null) {
                try {
                    pointCnt = Integer.parseInt(String.valueOf(pointCntObj));
                } catch (NumberFormatException ignored) {
                }
            }

            if ("1".equals(lineType) && pointCnt > 0) {
                for (int i = 1; i <= pointCnt; i++) {
                    Map<String, Object> pointParams = new HashMap<>();
                    pointParams.put("userId", params.get("userId"));
                    pointParams.put("grpNo", lineMap.get("grpNo"));
                    pointParams.put("linkNo", lineMap.get("linkNo"));
                    pointParams.put("ptIdx", i);
                    pointParams.put("xpoint", lineMap.get("pointX" + i));
                    pointParams.put("ypoint", lineMap.get("pointY" + i));

                    long itemNo = pointAddMapper.selectPointItemNo(pointParams);
                    pointParams.put("itemNo", itemNo);
                    pointAddMapper.updateLinkPoint(pointParams);
                    pointAddMapper.insertPointItemRecord(pointParams);
                    pointItemNos.add(itemNo);
                }
            }
        }

        params.put("pointList", pointItemNos);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("LINK", lineSettingMapper.selectLinkInfo(params));
        if (!pointItemNos.isEmpty()) {
            returnMap.put("POINT", lineSettingMapper.selectPointInfo(params));
        } else {
            returnMap.put("POINT", null);
        }
        return returnMap;
    }

    @Transactional
    public List<TopoLinkDto> addMultiLink(Map<String, Object> params) {
        lineSettingMapper.insertMultiLink(params);
        return lineSettingMapper.selectLinkInfo(params);
    }

    public List<TopoLinkDto> getLineInfo(Map<String, Object> params) {
        return lineSettingMapper.selectLinkInfo(params);
    }

    @Transactional
    public void saveLineStyle(Map<String, Object> params) {
        lineSettingMapper.updateLinkStyle(params);

        Object rangeType = params.get("rangeType");
        if ("GRP".equals(rangeType)) {
            lineSettingMapper.updateLinkStyleByGrp(params);
        }
    }

    public List<TopoItemDto> getCopyPointItemInfo(Map<String, Object> params) {
        return lineSettingMapper.selectCopyPointItemInfo(params);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public void addAutoLine(Map<String, Object> params) {
        List<Map<String, Object>> lineList = (List<Map<String, Object>>) params.get("list");
        for (Map<String, Object> lineMap : lineList) {
            lineMap.put("userId", params.get("userId"));
            lineSettingMapper.insertAutoLink(lineMap);
        }
    }
}
