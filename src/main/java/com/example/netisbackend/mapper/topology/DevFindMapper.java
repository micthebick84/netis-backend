package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.MapDevFindDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DevFindMapper {

    List<MapDevFindDto> selectDevFindList(Map<String, Object> map);

    List<MapDevFindDto> selectDevFindListSchool4(Map<String, Object> map);
}
