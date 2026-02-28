package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.*;
import com.example.netisbackend.service.topology.D3TopoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/d3")
@RequiredArgsConstructor
public class D3TopoController {

    private final D3TopoService d3TopoService;

    @GetMapping("/edit-yn")
    public ApiResponse<String> getTopoEditYn(@RequestParam String userId) {
        return ApiResponse.success(d3TopoService.getTopoEditYn(userId));
    }

    @PostMapping("/top-grp-info")
    public ApiResponse<List<MapTopGrpDto>> getMapTopGrpInfo(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(d3TopoService.getMapTopGrpInfo(params));
    }

    @PostMapping("/share-grp-list")
    public ApiResponse<List<MapTopGrpDto>> getTopoIsShareGrpList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(d3TopoService.getTopoIsShareGrpList(params));
    }

    @PostMapping("/item-list")
    public ApiResponse<List<TopoItemDto>> getTopoItemList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(d3TopoService.getTopoItemList(params));
    }

    @PostMapping("/link-list")
    public ApiResponse<List<TopoLinkDto>> getTopoLinkList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(d3TopoService.getTopoLinkList(params));
    }

    @PostMapping("/grp-info")
    public ApiResponse<MapTopoGrpDto> getTopoGrpInfo(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(d3TopoService.getTopoGrpInfo(params));
    }

    @PostMapping("/parent-grp-no")
    public ApiResponse<Long> getParentGrpNo(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(d3TopoService.getParentGrpNo(params));
    }

    @GetMapping("/com-img-list")
    public ApiResponse<List<ComImgDto>> getMapComImgList() {
        return ApiResponse.success(d3TopoService.getMapComImgList());
    }

    @PostMapping("/error-list")
    public ApiResponse<List<TopoErrorDto>> getTopoErrorList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(d3TopoService.getTopoErrorList(params));
    }
}
