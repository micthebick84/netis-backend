package com.example.netisbackend.service;

import com.example.netisbackend.dto.menu.MenuMgmtDto;
import com.example.netisbackend.mapper.MenuMgmtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuMgmtService {

    private final MenuMgmtMapper menuMgmtMapper;

    public List<MenuMgmtDto> getPageList(String siteName) {
        return menuMgmtMapper.selectPageList(siteName);
    }

    public List<MenuMgmtDto> getPageGroupList(int menuPageNo, String siteName) {
        return menuMgmtMapper.selectPageGroupList(menuPageNo, siteName);
    }

    public List<MenuMgmtDto> getMenuList(
            int menuPageGrpNo, int menuPageNo, String siteName) {
        return menuMgmtMapper.selectMenuList(menuPageGrpNo, menuPageNo, siteName);
    }
}
