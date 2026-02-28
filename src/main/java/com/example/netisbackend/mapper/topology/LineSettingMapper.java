package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.TopoItemDto;
import com.example.netisbackend.dto.topology.TopoLinkDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LineSettingMapper {

    void insertLink(Map<String, Object> params);

    void insertMultiLink(Map<String, Object> params);

    List<TopoLinkDto> selectLinkInfo(Map<String, Object> params);

    List<TopoItemDto> selectPointInfo(Map<String, Object> params);

    void updateLinkStyle(Map<String, Object> params);

    void updateLinkStyleByGrp(Map<String, Object> params);

    List<TopoItemDto> selectCopyPointItemInfo(Map<String, Object> params);

    void insertAutoLink(Map<String, Object> params);
}
