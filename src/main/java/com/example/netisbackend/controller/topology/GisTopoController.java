package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.GisItemDto;
import com.example.netisbackend.service.topology.GisTopoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/gis")
@RequiredArgsConstructor
public class GisTopoController {

    private final GisTopoService gisTopoService;

    @PostMapping("/group-info")
    public ApiResponse<Map<String, Object>> getGroupInfo(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(gisTopoService.getGroupInfo(params));
    }

    @PostMapping("/item-list")
    public ApiResponse<List<Map<String, Object>>> getGisItemList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(gisTopoService.getGisItemList(params));
    }

    @PostMapping("/save-item-latlnt")
    public ApiResponse<Void> saveItemLatLnt(@RequestBody Map<String, Object> params) {
        @SuppressWarnings("unchecked")
        List<GisItemDto> list = (List<GisItemDto>) params.get("list");
        String userId = (String) params.get("userId");
        gisTopoService.saveItemLatLnt(list, userId);
        return ApiResponse.success("저장되었습니다.", null);
    }

    @PostMapping("/save-group-latlnt")
    public ApiResponse<Void> saveGroupLatLnt(@RequestBody Map<String, Object> params) {
        gisTopoService.saveGroupLatLnt(params);
        return ApiResponse.success("저장되었습니다.", null);
    }

    @PostMapping("/delete-item")
    public ApiResponse<Void> deleteGisItem(@RequestBody Map<String, Object> params) {
        @SuppressWarnings("unchecked")
        List<GisItemDto> list = (List<GisItemDto>) params.get("list");
        String userId = (String) params.get("userId");
        gisTopoService.deleteGisItem(list, userId);
        return ApiResponse.success("삭제되었습니다.", null);
    }
}
