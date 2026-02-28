package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.TopoItemDto;
import com.example.netisbackend.dto.topology.TopoLinkDto;
import com.example.netisbackend.service.topology.LineSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/line-setting")
@RequiredArgsConstructor
public class LineSettingController {

    private final LineSettingService lineSettingService;

    @PostMapping("/add-line")
    public ApiResponse<Map<String, Object>> addLine(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(lineSettingService.addLine(params));
    }

    @PostMapping("/add-multi-link")
    public ApiResponse<List<TopoLinkDto>> addMultiLink(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(lineSettingService.addMultiLink(params));
    }

    @GetMapping("/line-info")
    public ApiResponse<List<TopoLinkDto>> getLineInfo(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(lineSettingService.getLineInfo(params));
    }

    @PostMapping("/save-line-style")
    public ApiResponse<Void> saveLineStyle(@RequestBody Map<String, Object> params) {
        lineSettingService.saveLineStyle(params);
        return ApiResponse.success(null);
    }

    @GetMapping("/copy-point-item-info")
    public ApiResponse<List<TopoItemDto>> getCopyPointItemInfo(@RequestParam Map<String, Object> params) {
        if (params.containsKey("mngNoList") && params.get("mngNoList") != null
                && !params.get("mngNoList").toString().isEmpty()) {
            String[] mngNoList = params.get("mngNoList").toString().split(",");
            params.put("mngNoList", mngNoList);
        }
        return ApiResponse.success(lineSettingService.getCopyPointItemInfo(params));
    }

    @PostMapping("/add-auto-line")
    public ApiResponse<Void> addAutoLine(@RequestBody Map<String, Object> params) {
        lineSettingService.addAutoLine(params);
        return ApiResponse.success(null);
    }
}
