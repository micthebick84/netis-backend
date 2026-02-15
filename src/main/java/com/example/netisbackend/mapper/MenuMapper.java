package com.example.netisbackend.mapper;

import com.example.netisbackend.dto.menu.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {

    List<PageDto> selectHierarchicalMenuList(
        @Param("userId") String userId,
        @Param("siteName") String siteName,
        @Param("auth") String auth,
        @Param("menuAuthNo") int menuAuthNo
    );

    List<MenuDto> selectMenuListAll(Map<String, Object> param);

    List<Map<String, Object>> selectPageGroupList(
        @Param("siteName") String siteName
    );

    List<Map<String, Object>> selectPageList(
        @Param("siteName") String siteName
    );

    List<LayoutMenuDto> selectLayoutMenuList(
        @Param("siteName") String siteName
    );

    List<LayoutMenuCondDto> selectLayoutMenuCondList(Map<String, Object> param);

    int selectMenuAuthExistCnt(
        @Param("userId") String userId,
        @Param("guid") String guid
    );

    String selectDashMenuNo();

    Map<String, Object> selectMenuLoc(@Param("guid") String guid);
}
