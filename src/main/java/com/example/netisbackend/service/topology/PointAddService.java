package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.TopoItemDto;
import com.example.netisbackend.mapper.topology.D3TopoMapper;
import com.example.netisbackend.mapper.topology.PointAddMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PointAddService {

    private final PointAddMapper pointAddMapper;
    private final D3TopoMapper d3TopoMapper;

    public long getPointItemNo(Map<String, Object> params) {
        return pointAddMapper.selectPointItemNo(params);
    }

    @Transactional
    public List<TopoItemDto> addPointItem(Map<String, Object> params) {
        long itemNo = pointAddMapper.selectPointItemNo(params);
        params.put("itemNo", itemNo);

        pointAddMapper.updateLinkPoint(params);
        pointAddMapper.insertPointItemRecord(params);

        // Use ProcEvt or CmEvt based on parameter
        Object useProcEvt = params.get("useProcEvt");
        if (useProcEvt != null && Boolean.TRUE.equals(useProcEvt)) {
            return d3TopoMapper.selectTopoItemListProcEvt(params);
        }
        return d3TopoMapper.selectTopoItemListCmEvt(params);
    }
}
