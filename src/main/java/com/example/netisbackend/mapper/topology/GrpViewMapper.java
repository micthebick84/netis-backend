package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.MapGrpViewDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GrpViewMapper {

    List<MapGrpViewDto> selectGrpViewList(Map<String, Object> map);

    List<MapGrpViewDto> selectRegGrpViewList(Map<String, Object> map);

    List<MapGrpViewDto> selectGrpViewAuthList(Map<String, Object> map);

    List<MapGrpViewDto> selectRegGrpViewAuthList(Map<String, Object> map);

    List<MapGrpViewDto> selectGrpViewChildList(Map<String, Object> map);

    List<MapGrpViewDto> selectRegGrpViewChildList(Map<String, Object> map);
}
