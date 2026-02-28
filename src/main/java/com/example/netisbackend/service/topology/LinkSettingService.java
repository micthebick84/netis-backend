package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.LinkPollingDto;
import com.example.netisbackend.dto.topology.MapDevDto;
import com.example.netisbackend.dto.topology.MapLineDto;
import com.example.netisbackend.dto.topology.TopoLinkDto;
import com.example.netisbackend.mapper.topology.LineSettingMapper;
import com.example.netisbackend.mapper.topology.LinkSettingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LinkSettingService {

    private final LinkSettingMapper linkSettingMapper;
    private final LineSettingMapper lineSettingMapper;

    public List<MapDevDto> getDevList(Map<String, Object> params) {
        Object testAll = params.get("testAll");
        if (testAll != null && "true".equals(String.valueOf(testAll))) {
            params.put("isAll", true);
        } else {
            params.put("isAll", false);
        }
        return linkSettingMapper.selectDevList(params);
    }

    public List<MapLineDto> getIfList(Map<String, Object> params) {
        return linkSettingMapper.selectIfList(params);
    }

    public List<LinkPollingDto> getMultiLinkPollingList(Map<String, Object> params) {
        return linkSettingMapper.selectMultiLinkPollingList(params);
    }

    @Transactional
    public List<TopoLinkDto> editLinkPolling(Map<String, Object> params) {
        linkSettingMapper.updateLinkPolling(params);
        return lineSettingMapper.selectLinkInfo(params);
    }

    @Transactional
    public void deleteMultiLinkPolling(Map<String, Object> params) {
        linkSettingMapper.deleteMultiLinkPolling(params);
    }

    @Transactional
    public void saveMultiLinkPolling(Map<String, Object> params) {
        linkSettingMapper.insertMultiLinkPolling(params);
    }

    @Transactional
    public List<TopoLinkDto> editLinkInfo(Map<String, Object> params) {
        linkSettingMapper.updateLinkInfo(params);
        return lineSettingMapper.selectLinkInfo(params);
    }
}
