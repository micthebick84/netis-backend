package com.example.netisbackend.service.topology;

import com.example.netisbackend.mapper.topology.MapInitMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapInitService {

    private final MapInitMapper mapInitMapper;

    public int getMapInitAuth(Map<String, Object> params) {
        return mapInitMapper.selectMapAuth(params);
    }

    @Transactional
    public void saveMapInit(Map<String, Object> params) {
        int isShare = mapInitMapper.selectMapAuth(params);
        if (isShare == 1) {
            throw new RuntimeException("상속계정은 맵 초기화 권한이 없습니다.");
        }

        mapInitMapper.deleteExistItem(params);
        mapInitMapper.insertGroup(params);
        mapInitMapper.insertGroupItem(params);
        mapInitMapper.insertDevItem(params);
        mapInitMapper.insertSubnetItem(params);
        // Rack items are not initialized to avoid permission issues
        // mapInitMapper.insertSvrGrp(params);
        // mapInitMapper.insertSvrItem(params);

        String mapUserId = mapInitMapper.selectMapId(params.get("userId").toString());
        mapInitMapper.procSpMakeTopoLeaf(mapUserId);
    }
}
