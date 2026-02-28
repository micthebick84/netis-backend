package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.MapTopoGrpDto;
import com.example.netisbackend.dto.topology.TopoRackDto;
import com.example.netisbackend.dto.topology.TopoRackSensorDto;
import com.example.netisbackend.service.topology.RackTopoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/rack")
@RequiredArgsConstructor
public class RackTopoController {

    private final RackTopoService rackTopoService;

    @PostMapping("/grp-list")
    public ApiResponse<List<MapTopoGrpDto>> getTopoRackGrpList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(rackTopoService.getTopoRackGrpList(params));
    }

    @PostMapping("/list")
    public ApiResponse<List<TopoRackDto>> getTopoRackList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(rackTopoService.getTopoRackList(params));
    }

    @PostMapping("/sensor-list")
    public ApiResponse<List<TopoRackSensorDto>> getTopoRackSensorList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(rackTopoService.getTopoRackSensorList(params));
    }

    @GetMapping("/grp-sensor-list")
    public ApiResponse<List<TopoRackSensorDto>> getTopoGrpSensorList(@RequestParam long grpNo) {
        return ApiResponse.success(rackTopoService.getTopoGrpSensorList(grpNo));
    }

    @GetMapping("/all-sensor-list")
    public ApiResponse<List<TopoRackSensorDto>> getTopoSensorList(@RequestParam long grpNo) {
        return ApiResponse.success(rackTopoService.getTopoSensorList(grpNo));
    }
}
