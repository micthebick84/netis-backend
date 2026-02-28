package com.example.netisbackend.mapper.topology;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PointAddMapper {

    long selectPointItemNo(Map<String, Object> params);

    void updateLinkPoint(Map<String, Object> params);

    void insertPointItemRecord(Map<String, Object> params);
}
