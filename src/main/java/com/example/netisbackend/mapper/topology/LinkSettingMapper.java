package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.LinkPollingDto;
import com.example.netisbackend.dto.topology.MapDevDto;
import com.example.netisbackend.dto.topology.MapLineDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LinkSettingMapper {

    List<MapDevDto> selectDevList(Map<String, Object> params);

    List<MapLineDto> selectIfList(Map<String, Object> params);

    List<LinkPollingDto> selectMultiLinkPollingList(Map<String, Object> params);

    void updateLinkPolling(Map<String, Object> params);

    void deleteMultiLinkPolling(Map<String, Object> params);

    void insertMultiLinkPolling(Map<String, Object> params);

    void updateLinkInfo(Map<String, Object> params);
}
