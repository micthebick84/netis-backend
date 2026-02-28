package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.LinkViewDto;
import com.example.netisbackend.dto.topology.MapDevFindDto;
import com.example.netisbackend.dto.topology.MapGrpViewDto;
import com.example.netisbackend.mapper.topology.DevFindMapper;
import com.example.netisbackend.mapper.topology.GrpViewMapper;
import com.example.netisbackend.mapper.topology.LinkViewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final DevFindMapper devFindMapper;
    private final GrpViewMapper grpViewMapper;
    private final LinkViewMapper linkViewMapper;

    /**
     * 장비찾기 목록 조회
     * topoGrpNo > 0 이면 school4 권한 필터 적용
     */
    public List<MapDevFindDto> getDevFindList(Map<String, Object> params) {
        int topoGrpNo = 0;
        if (params.containsKey("sessTopoAuthGrpNo") && params.get("sessTopoAuthGrpNo") != null) {
            topoGrpNo = Integer.parseInt(params.get("sessTopoAuthGrpNo").toString());
        }

        if (topoGrpNo > 0) {
            return devFindMapper.selectDevFindListSchool4(params);
        } else {
            return devFindMapper.selectDevFindList(params);
        }
    }

    /**
     * 그룹 조회 (토폴로지 그룹 트리)
     */
    public List<MapGrpViewDto> getGrpViewList(Map<String, Object> params) {
        if (!params.containsKey("topGrpNo") || params.get("topGrpNo") == null) {
            params.put("topGrpNo", 0);
        }
        return grpViewMapper.selectGrpViewList(params);
    }

    /**
     * 등록 그룹 조회
     */
    public List<MapGrpViewDto> getRegGrpViewList(Map<String, Object> params) {
        return grpViewMapper.selectRegGrpViewList(params);
    }

    /**
     * 폴링 링크 목록 조회
     */
    public List<LinkViewDto> getPollingLinkList(Map<String, Object> params) {
        return linkViewMapper.selectPollingLinkList(params);
    }
}
