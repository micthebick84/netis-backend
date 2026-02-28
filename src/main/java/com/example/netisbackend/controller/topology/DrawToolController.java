package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.MapDrawToolDto;
import com.example.netisbackend.dto.topology.MapSplineToolDto;
import com.example.netisbackend.service.topology.DrawToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/draw-tool")
@RequiredArgsConstructor
public class DrawToolController {

    private final DrawToolService drawToolService;

    // ==================== Draw Tool ====================

    @PostMapping("/list")
    public ApiResponse<List<MapDrawToolDto>> getDrawToolList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(drawToolService.getDrawToolList(params));
    }

    @PostMapping("/add")
    public ApiResponse<MapDrawToolDto> addDrawTool(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(drawToolService.addDrawTool(params));
    }

    @PostMapping("/edit")
    public ApiResponse<Integer> editDrawTool(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(drawToolService.editDrawTool(params));
    }

    @PostMapping("/save-conf")
    public ApiResponse<MapDrawToolDto> saveDrawShapeConf(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(drawToolService.saveDrawShapeConf(params));
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/delete")
    public ApiResponse<String> deleteDrawTools(@RequestBody Map<String, Object> params) {
        String userId = (String) params.get("userId");
        List<Map<String, Object>> delItemList = (List<Map<String, Object>>) params.get("delItemList");
        drawToolService.deleteDrawTools(userId, delItemList);
        return ApiResponse.success("삭제되었습니다.");
    }

    @PostMapping("/copy")
    public ApiResponse<MapDrawToolDto> copyDrawTool(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(drawToolService.copyDrawTool(params));
    }

    // ==================== Spline Tool ====================

    @PostMapping("/spline/list")
    public ApiResponse<List<MapSplineToolDto>> getSplineToolList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(drawToolService.getSplineToolList(params));
    }

    @PostMapping("/spline/add")
    public ApiResponse<MapSplineToolDto> addSplineTool(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(drawToolService.addSplineTool(params));
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/spline/delete")
    public ApiResponse<String> deleteSplineTools(@RequestBody Map<String, Object> params) {
        String userId = (String) params.get("userId");
        List<Map<String, Object>> delItemList = (List<Map<String, Object>>) params.get("delItemList");
        drawToolService.deleteSplineTools(userId, delItemList);
        return ApiResponse.success("삭제되었습니다.");
    }
}
