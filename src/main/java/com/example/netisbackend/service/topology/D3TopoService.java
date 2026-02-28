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

    public String getTopoEditYn(String userId) {
        return d3TopoMapper.selectTopoEditYn(userId);
    }

    public List<MapTopGrpDto> getMapTopGrpInfo(Map<String, Object> params) {
        return d3TopoMapper.selectMapTopGrpInfo(params);
    }

    public List<MapTopGrpDto> getTopoIsShareGrpList(Map<String, Object> params) {
        return d3TopoMapper.selectTopoIsShareGrpList(params);
    }

    public List<TopoItemDto> getTopoItemList(Map<String, Object> params) {
        // Use ProcEvt if event count exceeds threshold, otherwise CmEvt
        Object useProcEvt = params.get("useProcEvt");
        if (useProcEvt != null && Boolean.TRUE.equals(useProcEvt)) {
            return d3TopoMapper.selectTopoItemListProcEvt(params);
        }
        return d3TopoMapper.selectTopoItemListCmEvt(params);
    }

    public List<TopoLinkDto> getTopoLinkList(Map<String, Object> params) {
        return d3TopoMapper.selectTopoLinkList(params);
    }

    public MapTopoGrpDto getTopoGrpInfo(Map<String, Object> params) {
        return d3TopoMapper.selectTopoGrpInfo(params);
    }

    public long getParentGrpNo(Map<String, Object> params) {
        return d3TopoMapper.selectParentGrpNo(params);
    }

    public List<ComImgDto> getMapComImgList() {
        return d3TopoMapper.selectMapComImgList();
    }

    public List<TopoErrorDto> getTopoErrorList(Map<String, Object> params) {
        Object useProcEvt = params.get("useProcEvt");
        if (useProcEvt != null && Boolean.TRUE.equals(useProcEvt)) {
            return d3TopoMapper.selectTopoErrorListProcEvt(params);
        }
        return d3TopoMapper.selectTopoErrorListCmEvt(params);
    }
}
