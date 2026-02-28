package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.MapGrpTreeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GrpMoveMapper {

    String selectGrpNameByGrpNo(Map<String, Object> params);

    List<MapGrpTreeDto> selectGrpTreeList(Map<String, Object> params);

    int selectLinkCnt(Map<String, Object> params);

    List<Map<String, Object>> selectPointInfo(Map<String, Object> params);

    void deletePointForItem(Map<String, Object> params);

    void deleteLinkForItem(Map<String, Object> params);

    void updateGrpNoForItem(Map<String, Object> params);

    void updateGrpParentForGrpItem(Map<String, Object> params);

    List<MapGrpTreeDto> selectGrpListByItemNo(Map<String, Object> params);

    void procSpMakeTopoLeafMove(Map<String, Object> params);

    void procSpMakeTopoLeaf(@Param("userId") String userId);

    String selectMapId(@Param("userId") String userId);
}
