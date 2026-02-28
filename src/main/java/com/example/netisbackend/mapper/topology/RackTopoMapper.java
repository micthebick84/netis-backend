package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.MapTopoGrpDto;
import com.example.netisbackend.dto.topology.TopoRackDto;
import com.example.netisbackend.dto.topology.TopoRackSensorDto;
import com.example.netisbackend.dto.topology.TopoRackSlotDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RackTopoMapper {

    List<MapTopoGrpDto> selectTopoRackGrpList(Map<String, Object> params);

    List<TopoRackDto> selectTopoRackList(Map<String, Object> params);

    List<TopoRackSlotDto> selectTopoRackSlotList(@Param("rackNo") Long rackNo);

    List<TopoRackSensorDto> selectTopoRacKSensorList(Map<String, Object> params);

    List<TopoRackSensorDto> selectTopoGrpSensorList(@Param("grpNo") long grpNo);

    List<TopoRackSensorDto> selectTopoSensorList(@Param("grpNo") long grpNo);
}
