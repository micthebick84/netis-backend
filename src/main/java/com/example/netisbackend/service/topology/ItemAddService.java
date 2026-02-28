package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.*;
import com.example.netisbackend.mapper.topology.ItemAddMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ItemAddService {

    private final ItemAddMapper itemAddMapper;

    // ==================== 그룹 ====================

    @Transactional
    public void addGrp(Map<String, Object> paramMap) {
        // 등록그룹 추가시 이미 등록된 그룹이 있을 경우 uniqId 중복 방지를 위해 null 값 적용
        if (paramMap.get("uniqId") != null) {
            int cnt = itemAddMapper.selectGrpUniqIdDup(paramMap);
            if (cnt > 0) {
                paramMap.put("uniqId", null);
            }
        }
        paramMap.put("grpNo", itemAddMapper.selectNewGrpNo(paramMap));
        itemAddMapper.insertGrpItem(paramMap);

        String mapUserId = itemAddMapper.selectMapId((String) paramMap.get("userId"));
        itemAddMapper.procSpMakeTopoLeaf(mapUserId);
    }

    @Transactional
    public void addCopyGrp(Map<String, Object> paramMap) {
        Integer copyCount = Integer.valueOf(paramMap.get("copyCount").toString());
        List<Map<String, Object>> list = (List<Map<String, Object>>) paramMap.get("list");
        for (Map<String, Object> map : list) {
            paramMap.put("itemNo", map.get("itemNo"));
            paramMap.put("grpNo", map.get("grpNo"));
        }

        String mapUserId = itemAddMapper.selectMapId((String) paramMap.get("userId"));
        for (int i = 0; i < copyCount; i++) {
            paramMap.put("cnt", i + 1);
            itemAddMapper.insertCopyGrpItem(paramMap);
            itemAddMapper.procSpMakeTopoLeaf(mapUserId);
        }
    }

    @Transactional
    public void addCloneGrp(Map<String, Object> paramMap) {
        Integer copyCount = Integer.valueOf(paramMap.get("copyCount").toString());
        List<Map<String, Object>> list = (List<Map<String, Object>>) paramMap.get("list");
        for (Map<String, Object> map : list) {
            paramMap.put("itemNo", map.get("itemNo"));
            paramMap.put("grpNo", map.get("grpNo"));
        }

        // 복제대상 그룹 안에 있는 그룹 제외 Item
        List<Map<String, Object>> itemList = itemAddMapper.selectCloneTargetItemList(paramMap);
        paramMap.put("grpCloneItems", itemList);

        // 복제대상 그룹 안에 장비의 Link
        List<Map<String, Object>> linkList = itemAddMapper.selectCloneTargetLinkList(paramMap);
        paramMap.put("grpCloneLinks", linkList);

        String mapUserId = itemAddMapper.selectMapId((String) paramMap.get("userId"));
        for (int i = 0; i < copyCount; i++) {
            paramMap.put("cnt", i + 1);
            itemAddMapper.insertCloneGrpItem(paramMap);
            itemAddMapper.procSpMakeTopoLeaf(mapUserId);
        }
    }

    // ==================== 장비 ====================

    public List<MapRegDevDto> getRegDevList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegDevList(paramMap);
    }

    @Transactional
    public void addDev(Map<String, Object> paramMap) {
        itemAddMapper.insertDevItem(paramMap);
    }

    @Transactional
    public void addCopyDev(Map<String, Object> paramMap) {
        itemAddMapper.insertCopyDevItem(paramMap);
    }

    // ==================== 서버 ====================

    public List<MapRegSvrDto> getRegSvrList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegSvrList(paramMap);
    }

    @Transactional
    public void addSvr(Map<String, Object> paramMap) {
        itemAddMapper.insertSvrItem(paramMap);
    }

    // ==================== 서브넷 ====================

    public List<MapRegSubDto> getRegSubList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegSubList(paramMap);
    }

    @Transactional
    public void addSub(Map<String, Object> paramMap) {
        itemAddMapper.insertSubItem(paramMap);
    }

    // ==================== 임의장비 ====================

    @Transactional
    public void addEtc(Map<String, Object> paramMap) {
        itemAddMapper.insertEtcItem(paramMap);
    }

    // ==================== RACK ====================

    public List<MapRegRackDto> getRegRackList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegRackList(paramMap);
    }

    @Transactional
    public void addRack(Map<String, Object> paramMap) {
        itemAddMapper.insertRackItem(paramMap);
    }

    // ==================== AP ====================

    public List<MapRegApDto> getRegApList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegApList(paramMap);
    }

    @Transactional
    public void addAp(Map<String, Object> paramMap) {
        itemAddMapper.insertApItem(paramMap);
    }

    // ==================== 센서 ====================

    public List<MapRegSensorDto> getRegSensorList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegSensorList(paramMap);
    }

    @Transactional
    public void addSensor(Map<String, Object> paramMap) {
        itemAddMapper.insertSensorItem(paramMap);
    }

    // ==================== WAS ====================

    public List<MapRegWasDto> getRegWasList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegWasList(paramMap);
    }

    @Transactional
    public void addWas(Map<String, Object> paramMap) {
        itemAddMapper.insertWasItem(paramMap);
    }

    // ==================== DBMS ====================

    public List<MapRegDbmsDto> getRegDbmsList(Map<String, Object> paramMap) {
        return itemAddMapper.selectRegDbmsList(paramMap);
    }

    @Transactional
    public void addDbms(Map<String, Object> paramMap) {
        itemAddMapper.insertDbmsItem(paramMap);
    }

    // ==================== 일괄추가 ====================

    @Transactional
    public void addMeasureMultiDev(Map<String, Object> paramMap) {
        double calW = Double.parseDouble(paramMap.get("widthDef").toString()) / Double.parseDouble(paramMap.get("xWidth").toString());
        double calH = Double.parseDouble(paramMap.get("heightDef").toString()) / Double.parseDouble(paramMap.get("yHeight").toString());
        List<Map<String, Object>> multiList = new ArrayList<>();
        List<Map<String, Object>> etcList = new ArrayList<>();
        List<Map<String, Object>> list = (List<Map<String, Object>>) paramMap.get("list");

        for (Map<String, Object> map : list) {
            double xData = (calW * Double.parseDouble(map.get("xValue").toString())) * 10;
            double yData = (calH * Double.parseDouble(map.get("yValue").toString())) * 10;
            map.put("xPoint", xData);
            map.put("yPoint", yData);

            Map<String, Object> checkMap = itemAddMapper.selectRegItemCheck(map);
            if (checkMap != null) {
                if (checkMap.get("mngNo") != null && checkMap.get("itemNo") == null) {
                    map.put("mngNo", checkMap.get("mngNo"));
                    multiList.add(map);
                }
            } else {
                etcList.add(map);
            }
        }

        if (!multiList.isEmpty()) {
            paramMap.put("multiList", multiList);
            itemAddMapper.insertMeasureMultiDevItem(paramMap);
        }

        if (!etcList.isEmpty()) {
            paramMap.put("etcList", etcList);
            itemAddMapper.insertMeasureMultiDevEtcItem(paramMap);
        }
    }
}
