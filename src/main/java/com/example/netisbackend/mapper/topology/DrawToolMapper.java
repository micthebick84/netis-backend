package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.MapDrawToolDto;
import com.example.netisbackend.dto.topology.MapSplineToolDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DrawToolMapper {

    List<MapDrawToolDto> selectDrawToolList(Map<String, Object> params);

    int insertDrawTool(Map<String, Object> params);

    int updateDrawTool(Map<String, Object> params);

    void updateDrawShapeConf(Map<String, Object> params);

    int deleteDrawTool(@Param("drawNo") long drawNo);

    int insertCopyDrawTool(Map<String, Object> params);

    List<MapSplineToolDto> selectSplineToolList(Map<String, Object> params);

    int insertSplineTool(Map<String, Object> params);

    int updateSplineStyle(Map<String, Object> params);

    int deleteSplineTool(@Param("splineNo") long splineNo);
}
