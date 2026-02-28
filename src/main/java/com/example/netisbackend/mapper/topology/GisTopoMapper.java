package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.GisItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GisTopoMapper {

    Map<String, Object> selectGroupInfo(Map<String, Object> params);

    List<Map<String, Object>> selectGisItemList(Map<String, Object> params);

    void updateItemLatLnt(@Param("list") List<GisItemDto> list, @Param("userId") String userId);

    void updateGroupLatLng(Map<String, Object> params);

    void deleteGisItem(@Param("list") List<GisItemDto> list, @Param("userId") String userId);
}
