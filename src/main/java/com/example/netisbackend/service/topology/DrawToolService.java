package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.MapDrawToolDto;
import com.example.netisbackend.dto.topology.MapSplineToolDto;
import com.example.netisbackend.mapper.topology.DrawToolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DrawToolService {

    private final DrawToolMapper drawToolMapper;

    // ==================== Draw Tool ====================

    public List<MapDrawToolDto> getDrawToolList(Map<String, Object> params) {
        return drawToolMapper.selectDrawToolList(params);
    }

    @Transactional
    public MapDrawToolDto addDrawTool(Map<String, Object> params) {
        drawToolMapper.insertDrawTool(params);
        List<MapDrawToolDto> list = drawToolMapper.selectDrawToolList(params);
        return (list != null && !list.isEmpty()) ? list.get(0) : null;
    }

    @Transactional
    public int editDrawTool(Map<String, Object> params) {
        return drawToolMapper.updateDrawTool(params);
    }

    @Transactional
    public MapDrawToolDto saveDrawShapeConf(Map<String, Object> params) {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> drawList = (List<Map<String, Object>>) params.get("drawList");
        if (drawList == null || drawList.isEmpty()) {
            throw new RuntimeException("저장할 데이터가 없습니다.");
        }

        for (Map<String, Object> drawItem : drawList) {
            drawToolMapper.updateDrawShapeConf(drawItem);
            params.put("grpNo", drawItem.get("grpNo"));
            params.put("drawNo", drawItem.get("drawNo"));
        }

        List<MapDrawToolDto> list = drawToolMapper.selectDrawToolList(params);
        return (list != null && !list.isEmpty()) ? list.get(0) : null;
    }

    @Transactional
    public void deleteDrawTools(String userId, List<Map<String, Object>> delItemList) {
        if (delItemList != null && !delItemList.isEmpty()) {
            for (Map<String, Object> delItem : delItemList) {
                long drawNo = Long.parseLong(String.valueOf(delItem.get("drawNo")));
                drawToolMapper.deleteDrawTool(drawNo);
            }
        }
    }

    @Transactional
    public MapDrawToolDto copyDrawTool(Map<String, Object> params) {
        drawToolMapper.insertCopyDrawTool(params);
        List<MapDrawToolDto> list = drawToolMapper.selectDrawToolList(params);
        return (list != null && !list.isEmpty()) ? list.get(0) : null;
    }

    // ==================== Spline Tool ====================

    public List<MapSplineToolDto> getSplineToolList(Map<String, Object> params) {
        return drawToolMapper.selectSplineToolList(params);
    }

    @Transactional
    public MapSplineToolDto addSplineTool(Map<String, Object> params) {
        drawToolMapper.insertSplineTool(params);
        List<MapSplineToolDto> list = drawToolMapper.selectSplineToolList(params);
        return (list != null && !list.isEmpty()) ? list.get(0) : null;
    }

    @Transactional
    public int updateSplineStyle(Map<String, Object> params) {
        return drawToolMapper.updateSplineStyle(params);
    }

    @Transactional
    public void deleteSplineTools(String userId, List<Map<String, Object>> delItemList) {
        if (delItemList != null && !delItemList.isEmpty()) {
            for (Map<String, Object> delItem : delItemList) {
                long splineNo = Long.parseLong(String.valueOf(delItem.get("splineNo")));
                drawToolMapper.deleteSplineTool(splineNo);
            }
        }
    }
}
