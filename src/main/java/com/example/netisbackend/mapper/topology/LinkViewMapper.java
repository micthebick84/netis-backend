package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.LinkViewDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LinkViewMapper {

    List<LinkViewDto> selectPollingLinkList(Map<String, Object> map);
}
