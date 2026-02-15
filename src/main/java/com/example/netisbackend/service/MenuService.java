package com.example.netisbackend.service;

import com.example.netisbackend.dto.menu.*;
import com.example.netisbackend.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public List<PageDto> getHierarchicalMenuList(
            String userId, String siteName, String auth, int menuAuthNo) {
        return menuMapper.selectHierarchicalMenuList(
            userId, siteName, auth, menuAuthNo);
    }

    public List<MenuDto> getMenuListAll(Map<String, Object> param) {
        return menuMapper.selectMenuListAll(param);
    }

    public List<Map<String, Object>> getPageGroupList(String siteName) {
        return menuMapper.selectPageGroupList(siteName);
    }

    public List<Map<String, Object>> getPageList(String siteName) {
        return menuMapper.selectPageList(siteName);
    }

    public List<LayoutMenuDto> getLayoutMenuList(String siteName) {
        return menuMapper.selectLayoutMenuList(siteName);
    }

    public List<LayoutMenuCondDto> getLayoutMenuCondList(Map<String, Object> param) {
        return menuMapper.selectLayoutMenuCondList(param);
    }

    public int getMenuAuthExistCnt(String userId, String guid) {
        return menuMapper.selectMenuAuthExistCnt(userId, guid);
    }

    public String getDashMenuNo() {
        return menuMapper.selectDashMenuNo();
    }

    public Map<String, Object> getMenuLoc(String guid) {
        return menuMapper.selectMenuLoc(guid);
    }
}
