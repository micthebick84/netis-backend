package com.example.netisbackend.mapper.topology;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MapInitMapper {

    int selectMapAuth(Map<String, Object> params);

    void deleteExistItem(Map<String, Object> params);

    void insertGroup(Map<String, Object> params);

    void insertGroupItem(Map<String, Object> params);

    void insertDevItem(Map<String, Object> params);

    void insertSubnetItem(Map<String, Object> params);

    void insertSvrGrp(Map<String, Object> params);

    void insertSvrItem(Map<String, Object> params);

    String selectMapId(@Param("userId") String userId);

    void procSpMakeTopoLeaf(@Param("userId") String userId);
}
