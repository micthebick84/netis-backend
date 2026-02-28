package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.TopoItemDto;
import com.example.netisbackend.service.topology.PointAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/point-add")
@RequiredArgsConstructor
public class PointAddController {

    private final PointAddService pointAddService;

    @GetMapping("/point-item-no")
    public ApiResponse<Long> getPointItemNo(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(pointAddService.getPointItemNo(params));
    }

    @PostMapping("/add-point-item")
    public ApiResponse<List<TopoItemDto>> addPointItem(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(pointAddService.addPointItem(params));
    }
}
