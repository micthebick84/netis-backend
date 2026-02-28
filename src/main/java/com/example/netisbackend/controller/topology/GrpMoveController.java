package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.MapGrpTreeDto;
import com.example.netisbackend.service.topology.GrpMoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/grp-move")
@RequiredArgsConstructor
public class GrpMoveController {

    private final GrpMoveService grpMoveService;

    @PostMapping("/grp-name")
    public ApiResponse<String> getGrpName(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(grpMoveService.getGrpName(params));
    }

    @PostMapping("/grp-tree-list")
    public ApiResponse<List<MapGrpTreeDto>> getGrpTreeList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(grpMoveService.getGrpTreeList(params));
    }

    @PostMapping("/save")
    public ApiResponse<String> saveGrpMove(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(grpMoveService.saveGrpMove(params));
    }
}
