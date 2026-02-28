package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemAddMapper {

    // 그룹
    long selectNewGrpNo(Map<String, Object> paramMap);

    void insertGrpItem(Map<String, Object> paramMap);

    void insertCopyGrpItem(Map<String, Object> paramMap);

    void insertCloneGrpItem(Map<String, Object> paramMap);

    String selectMapId(@Param("userId") String userId);

    void procSpMakeTopoLeaf(@Param("userId") String userId);

    int selectGrpUniqIdDup(Map<String, Object> paramMap);

    // 장비
    List<MapRegDevDto> selectRegDevList(Map<String, Object> paramMap);

    void insertDevItem(Map<String, Object> paramMap);

    void insertCopyDevItem(Map<String, Object> paramMap);

    // 서버
    List<MapRegSvrDto> selectRegSvrList(Map<String, Object> paramMap);

    void insertSvrItem(Map<String, Object> paramMap);

    // 서브넷
    List<MapRegSubDto> selectRegSubList(Map<String, Object> paramMap);

    void insertSubItem(Map<String, Object> paramMap);

    // 임의장비
    void insertEtcItem(Map<String, Object> paramMap);

    // Rack
    List<MapRegRackDto> selectRegRackList(Map<String, Object> paramMap);

    void insertRackItem(Map<String, Object> paramMap);

    // AP
    List<MapRegApDto> selectRegApList(Map<String, Object> paramMap);

    void insertApItem(Map<String, Object> paramMap);

    // 센서
    List<MapRegSensorDto> selectRegSensorList(Map<String, Object> paramMap);

    void insertSensorItem(Map<String, Object> paramMap);

    // WAS
    List<MapRegWasDto> selectRegWasList(Map<String, Object> paramMap);

    void insertWasItem(Map<String, Object> paramMap);

    // DBMS
    List<MapRegDbmsDto> selectRegDbmsList(Map<String, Object> paramMap);

    void insertDbmsItem(Map<String, Object> paramMap);

    // 그룹복제용
    List<Map<String, Object>> selectCloneTargetItemList(Map<String, Object> paramMap);

    List<Map<String, Object>> selectCloneTargetLinkList(Map<String, Object> paramMap);

    // 일괄추가
    void insertMeasureMultiDevItem(Map<String, Object> paramMap);

    void insertMeasureMultiDevEtcItem(Map<String, Object> paramMap);

    Map<String, Object> selectRegItemCheck(Map<String, Object> paramMap);
}
