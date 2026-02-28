package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.MapGrpTreeDto;
import com.example.netisbackend.mapper.topology.GrpMoveMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class GrpMoveService {

    private final GrpMoveMapper grpMoveMapper;

    public String getGrpName(Map<String, Object> params) {
        return grpMoveMapper.selectGrpNameByGrpNo(params);
    }

    public List<MapGrpTreeDto> getGrpTreeList(Map<String, Object> params) {
        if (!params.containsKey("grpParent")) {
            params.put("grpParent", 0);
        }
        return grpMoveMapper.selectGrpTreeList(params);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public String saveGrpMove(Map<String, Object> params) {
        String userId = params.get("userId").toString();
        long grpNo = Long.parseLong(params.get("newGrpNo").toString());
        params.put("grpNo", grpNo);

        List<Integer> itemNos = (List<Integer>) params.get("itemNos");

        // Delete points for items that have links
        Map<String, Object> map = new HashMap<>();
        for (int itemNo : itemNos) {
            map.put("itemNo", itemNo);
            map.put("userId", userId);
            int linkCnt = grpMoveMapper.selectLinkCnt(map);
            if (linkCnt > 0) {
                List<Map<String, Object>> pointList = grpMoveMapper.selectPointInfo(map);
                if (!CollectionUtils.isEmpty(pointList)) {
                    for (Map<String, Object> pointMap : pointList) {
                        if (pointMap != null) {
                            pointMap.put("grpNo", grpNo);
                            pointMap.put("userId", userId);
                            grpMoveMapper.deletePointForItem(pointMap);
                        }
                    }
                }
            }
        }

        // Delete links
        grpMoveMapper.deleteLinkForItem(params);

        // Update item group number
        grpMoveMapper.updateGrpNoForItem(params);

        // If moved item is a group, update grp_parent in cm_topo_group
        grpMoveMapper.updateGrpParentForGrpItem(params);

        // Rebuild leaf structure
        String mapUserId = grpMoveMapper.selectMapId(userId);
        params.put("userId", mapUserId);

        List<MapGrpTreeDto> grpList = grpMoveMapper.selectGrpListByItemNo(params);
        if (!CollectionUtils.isEmpty(grpList)) {
            map = new HashMap<>();
            map.put("userId", mapUserId);
            for (MapGrpTreeDto grpDto : grpList) {
                map.put("grpNo", grpDto.getGrpNo());
                map.put("grpParent", params.get("newGrpNo"));
                grpMoveMapper.procSpMakeTopoLeafMove(map);
            }
        }

        return "저장되었습니다.";
    }
}
