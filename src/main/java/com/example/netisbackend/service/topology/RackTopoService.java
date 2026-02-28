package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.MapTopoGrpDto;
import com.example.netisbackend.dto.topology.TopoRackDto;
import com.example.netisbackend.dto.topology.TopoRackSensorDto;
import com.example.netisbackend.dto.topology.TopoRackSlotDto;
import com.example.netisbackend.mapper.topology.RackTopoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RackTopoService {

    private final RackTopoMapper rackTopoMapper;

    public List<MapTopoGrpDto> getTopoRackGrpList(Map<String, Object> params) {
        return rackTopoMapper.selectTopoRackGrpList(params);
    }

    public List<TopoRackDto> getTopoRackList(Map<String, Object> params) {
        List<TopoRackDto> rackList = rackTopoMapper.selectTopoRackList(params);
        for (TopoRackDto rack : rackList) {
            List<TopoRackSlotDto> slotList = rackTopoMapper.selectTopoRackSlotList(rack.getRackNo());
            rack.setTopoRackSlotList(slotList);
        }
        return rackList;
    }

    public List<TopoRackSensorDto> getTopoRackSensorList(Map<String, Object> params) {
        return rackTopoMapper.selectTopoRacKSensorList(params);
    }

    public List<TopoRackSensorDto> getTopoGrpSensorList(long grpNo) {
        return rackTopoMapper.selectTopoGrpSensorList(grpNo);
    }

    public List<TopoRackSensorDto> getTopoSensorList(long grpNo) {
        return rackTopoMapper.selectTopoSensorList(grpNo);
    }
}
