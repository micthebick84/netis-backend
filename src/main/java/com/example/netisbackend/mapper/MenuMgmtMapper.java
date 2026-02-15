package com.example.netisbackend.mapper;

import com.example.netisbackend.dto.menu.MenuMgmtDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMgmtMapper {

    List<MenuMgmtDto> selectPageList(
        @Param("siteName") String siteName
    );

    List<MenuMgmtDto> selectPageGroupList(
        @Param("menuPageNo") int menuPageNo,
        @Param("siteName") String siteName
    );

    List<MenuMgmtDto> selectMenuList(
        @Param("menuPageGrpNo") int menuPageGrpNo,
        @Param("menuPageNo") int menuPageNo,
        @Param("siteName") String siteName
    );
}
