package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface D3TopoMapper {

    String selectTopoEditYn(@Param("userId") String userId);

    List<MapTopGrpDto> selectMapTopGrpInfo(Map<String, Object> params);

    List<MapTopGrpDto> selectTopoIsShareGrpList(Map<String, Object> params);

    List<TopoItemDto> selectTopoItemListCmEvt(Map<String, Object> params);

    List<TopoItemDto> selectTopoItemListProcEvt(Map<String, Object> params);

    List<TopoLinkDto> selectTopoLinkList(Map<String, Object> params);

    MapTopoGrpDto selectTopoGrpInfo(Map<String, Object> params);

    long selectParentGrpNo(Map<String, Object> params);

    List<ComImgDto> selectMapComImgList();

    void insertComImg(Map<String, Object> params);

    List<TopoErrorDto> selectTopoErrorListCmEvt(Map<String, Object> params);

    List<TopoErrorDto> selectTopoErrorListProcEvt(Map<String, Object> params);
}
