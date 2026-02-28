package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.GisItemDto;
import com.example.netisbackend.mapper.topology.GisTopoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GisTopoService {

    private final GisTopoMapper gisTopoMapper;

    public Map<String, Object> getGroupInfo(Map<String, Object> params) {
        return gisTopoMapper.selectGroupInfo(params);
    }

    public List<Map<String, Object>> getGisItemList(Map<String, Object> params) {
        return gisTopoMapper.selectGisItemList(params);
    }

    @Transactional
    public void saveItemLatLnt(List<GisItemDto> list, String userId) {
        gisTopoMapper.updateItemLatLnt(list, userId);
    }

    @Transactional
    public void saveGroupLatLnt(Map<String, Object> params) {
        gisTopoMapper.updateGroupLatLng(params);
    }

    @Transactional
    public void deleteGisItem(List<GisItemDto> list, String userId) {
        gisTopoMapper.deleteGisItem(list, userId);
    }
}
