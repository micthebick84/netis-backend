package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.service.topology.MapInitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/topology/map-init")
@RequiredArgsConstructor
public class MapInitController {

    private final MapInitService mapInitService;

    @PostMapping("/auth")
    public ApiResponse<Integer> getMapInitAuth(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(mapInitService.getMapInitAuth(params));
    }

    @PostMapping("/save")
    public ApiResponse<Void> saveMapInit(@RequestBody Map<String, Object> params) {
        mapInitService.saveMapInit(params);
        return ApiResponse.success(null);
    }
}
