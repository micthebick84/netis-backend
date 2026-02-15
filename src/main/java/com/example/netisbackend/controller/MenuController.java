package com.example.netisbackend.controller;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.menu.*;
import com.example.netisbackend.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/hierarchical")
    public ApiResponse<List<PageDto>> getHierarchicalMenuList(
            @RequestParam String userId,
            @RequestParam String siteName,
            @RequestParam String auth,
            @RequestParam(defaultValue = "0") int menuAuthNo) {
        return ApiResponse.success(
            menuService.getHierarchicalMenuList(
                userId, siteName, auth, menuAuthNo));
    }

    @GetMapping
    public ApiResponse<List<MenuDto>> getMenuListAll(
            @RequestParam Map<String, Object> param) {
        return ApiResponse.success(menuService.getMenuListAll(param));
    }

    @GetMapping("/layout")
    public ApiResponse<List<LayoutMenuDto>> getLayoutMenuList(
            @RequestParam String siteName) {
        return ApiResponse.success(menuService.getLayoutMenuList(siteName));
    }

    @GetMapping("/layout-cond")
    public ApiResponse<List<LayoutMenuCondDto>> getLayoutMenuCondList(
            @RequestParam Map<String, Object> param) {
        return ApiResponse.success(menuService.getLayoutMenuCondList(param));
    }

    @GetMapping("/auth-check")
    public ApiResponse<Integer> getMenuAuthExistCnt(
            @RequestParam String userId,
            @RequestParam String guid) {
        return ApiResponse.success(
            menuService.getMenuAuthExistCnt(userId, guid));
    }

    @GetMapping("/dash-menu-no")
    public ApiResponse<String> getDashMenuNo() {
        return ApiResponse.success(menuService.getDashMenuNo());
    }

    @GetMapping("/location")
    public ApiResponse<Map<String, Object>> getMenuLoc(
            @RequestParam String guid) {
        return ApiResponse.success(menuService.getMenuLoc(guid));
    }
}
