package com.example.netisbackend.controller;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.menu.MenuMgmtDto;
import com.example.netisbackend.service.MenuMgmtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-mgmt")
@RequiredArgsConstructor
public class MenuMgmtController {

    private final MenuMgmtService menuMgmtService;

    @GetMapping("/pages")
    public ApiResponse<List<MenuMgmtDto>> getPageList(
            @RequestParam String siteName) {
        return ApiResponse.success(menuMgmtService.getPageList(siteName));
    }

    @GetMapping("/page-groups")
    public ApiResponse<List<MenuMgmtDto>> getPageGroupList(
            @RequestParam int menuPageNo,
            @RequestParam String siteName) {
        return ApiResponse.success(
            menuMgmtService.getPageGroupList(menuPageNo, siteName));
    }

    @GetMapping("/items")
    public ApiResponse<List<MenuMgmtDto>> getMenuList(
            @RequestParam int menuPageGrpNo,
            @RequestParam int menuPageNo,
            @RequestParam String siteName) {
        return ApiResponse.success(
            menuMgmtService.getMenuList(menuPageGrpNo, menuPageNo, siteName));
    }
}
