package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.LinkPollingDto;
import com.example.netisbackend.dto.topology.MapDevDto;
import com.example.netisbackend.dto.topology.MapLineDto;
import com.example.netisbackend.dto.topology.TopoLinkDto;
import com.example.netisbackend.service.topology.LinkSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/link-setting")
@RequiredArgsConstructor
public class LinkSettingController {

    private final LinkSettingService linkSettingService;

    @GetMapping("/dev-list")
    public ApiResponse<List<MapDevDto>> getDevList(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(linkSettingService.getDevList(params));
    }

    @GetMapping("/if-list")
    public ApiResponse<List<MapLineDto>> getIfList(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(linkSettingService.getIfList(params));
    }

    @GetMapping("/multi-link-polling-list")
    public ApiResponse<List<LinkPollingDto>> getMultiLinkPollingList(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(linkSettingService.getMultiLinkPollingList(params));
    }

    @PostMapping("/edit-link-polling")
    public ApiResponse<List<TopoLinkDto>> editLinkPolling(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(linkSettingService.editLinkPolling(params));
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/edit-multi-link-polling")
    public ApiResponse<List<TopoLinkDto>> editMultiLinkPolling(@RequestBody Map<String, Object> params) {
        linkSettingService.deleteMultiLinkPolling(params);
        List<Object> linkList = (ArrayList<Object>) params.get("linkList");
        if (linkList != null && !linkList.isEmpty()) {
            linkSettingService.saveMultiLinkPolling(params);
        }
        return ApiResponse.success(linkSettingService.editLinkInfo(params));
    }
}
