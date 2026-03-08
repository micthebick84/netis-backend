package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.*;
import com.example.netisbackend.mapper.topology.D3TopoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class D3TopoService {

    private final D3TopoMapper d3TopoMapper;

    /**
     * Resolve userId to parent_id if exists (child user inherits parent's topology data).
     * e.g. testuser99 (parent_id='testuser') → 'testuser'
     */
    private void resolveUserId(Map<String, Object> params) {
        Object userId = params.get("userId");
        if (userId != null) {
            String resolved = d3TopoMapper.resolveUserId(userId.toString());
            if (resolved != null) {
                params.put("userId", resolved);
            }
        }
    }

    public String getTopoEditYn(String userId) {
        String resolved = d3TopoMapper.resolveUserId(userId);
        return d3TopoMapper.selectTopoEditYn(resolved != null ? resolved : userId);
    }

    public List<MapTopGrpDto> getMapTopGrpInfo(Map<String, Object> params) {
        resolveUserId(params);
        return d3TopoMapper.selectMapTopGrpInfo(params);
    }

    public List<MapTopGrpDto> getTopoIsShareGrpList(Map<String, Object> params) {
        resolveUserId(params);
        return d3TopoMapper.selectTopoIsShareGrpList(params);
    }

    public List<TopoItemDto> getTopoItemList(Map<String, Object> params) {
        resolveUserId(params);
        if (!params.containsKey("evtLvlList") || params.get("evtLvlList") == null) {
            params.put("evtLvlList", List.of(1, 2, 3, 4, 5));
        }
        Object useProcEvt = params.get("useProcEvt");
        if (useProcEvt != null && Boolean.TRUE.equals(useProcEvt)) {
            return d3TopoMapper.selectTopoItemListProcEvt(params);
        }
        return d3TopoMapper.selectTopoItemListCmEvt(params);
    }

    public List<TopoLinkDto> getTopoLinkList(Map<String, Object> params) {
        resolveUserId(params);
        return d3TopoMapper.selectTopoLinkList(params);
    }

    public MapTopoGrpDto getTopoGrpInfo(Map<String, Object> params) {
        resolveUserId(params);
        return d3TopoMapper.selectTopoGrpInfo(params);
    }

    public long getParentGrpNo(Map<String, Object> params) {
        resolveUserId(params);
        return d3TopoMapper.selectParentGrpNo(params);
    }

    public List<ComImgDto> getMapComImgList() {
        return d3TopoMapper.selectMapComImgList();
    }

    public List<TopoErrorDto> getTopoErrorList(Map<String, Object> params) {
        resolveUserId(params);
        Object useProcEvt = params.get("useProcEvt");
        if (useProcEvt != null && Boolean.TRUE.equals(useProcEvt)) {
            return d3TopoMapper.selectTopoErrorListProcEvt(params);
        }
        return d3TopoMapper.selectTopoErrorListCmEvt(params);
    }
}
