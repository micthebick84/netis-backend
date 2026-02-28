package com.example.netisbackend.mapper.topology;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface ItemDelMapper {

    String selectKeyUserId(Map<String, Object> params);

    void deleteLink(Map<String, Object> params);

    void deleteLinkMulti(Map<String, Object> params);

    void deletePoint(Map<String, Object> params);

    void deleteItem(Map<String, Object> params);

    void deleteEtc(Map<String, Object> params);

    void deleteGroup(Map<String, Object> params);

    String selectMapId(@Param("userId") String userId);

    void procSpMakeTopoLeaf(@Param("userId") String userId);
}
