package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.ComImgDto;
import com.example.netisbackend.dto.topology.ErrActionDto;
import com.example.netisbackend.dto.topology.TopoEnvSettingDto;
import com.example.netisbackend.dto.topology.TopoItemImgDto;
import com.example.netisbackend.mapper.topology.D3TopoMapper;
import com.example.netisbackend.mapper.topology.DrawToolMapper;
import com.example.netisbackend.mapper.topology.ModeSettingMapper;
import com.example.netisbackend.dto.topology.MapTopoGrpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModeSettingService {

    private final ModeSettingMapper modeSettingMapper;
    private final D3TopoMapper d3TopoMapper;
    private final DrawToolMapper drawToolMapper;

    public List<ComImgDto> getComImgList(Map<String, Object> params) {
        return modeSettingMapper.selectComImgList(params);
    }

    @Transactional
    public ComImgDto addComImg(Map<String, Object> params) {
        // TODO: File I/O - save uploaded image file to storage
        // String imgKind2 = params.get("imgKind2").toString();
        // String folder = imgKind2.equals("BG") ? "bg" : "micons";
        // String imgExt = imgKind2.equals("BG") ? ".png" : ".PNG";
        // String fileName = params.get("imgUid").toString() + imgExt;
        // Save byte[] params.get("img") to file path: {uploadPath}/image/d3/{folder}/{fileName}

        modeSettingMapper.insertComImg(params);
        return modeSettingMapper.selectComImgInfo(params);
    }

    @Transactional
    public void saveComImg(Map<String, Object> params) {
        modeSettingMapper.updateComImg(params);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public void delComImg(Map<String, Object> params) {
        // DB delete
        modeSettingMapper.deleteComImg(params);

        // TODO: File I/O - delete image files from storage
        // String imgKind2 = params.get("imgKind2").toString();
        // String folder = imgKind2.equals("BG") ? "bg" : "micons";
        // String imgExt = imgKind2.equals("BG") ? ".png" : ".PNG";
        // List<Map<String, Object>> imgList = (List<Map<String, Object>>) params.get("imgList");
        // Delete each file: {uploadPath}/image/d3/{folder}/{imgUid}{imgExt}
    }

    public List<ErrActionDto> getErrActionList(Map<String, Object> params) {
        return modeSettingMapper.selectErrActionList(params);
    }

    @Transactional
    public String saveErrAction(Map<String, Object> params) {
        modeSettingMapper.updateErrAction(params);
        modeSettingMapper.procEventProc();
        return "저장되었습니다.";
    }

    @Transactional
    public String saveAllErrAction(Map<String, Object> params) {
        modeSettingMapper.updateAllErrAction(params);
        modeSettingMapper.procEventProc();
        return "저장되었습니다.";
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public void saveMapPosition(Map<String, Object> params) {
        List<Map<String, Object>> linkList = (List<Map<String, Object>>) params.get("linkList");
        List<Map<String, Object>> itemList = (List<Map<String, Object>>) params.get("itemList");
        List<Map<String, Object>> drawList = (List<Map<String, Object>>) params.get("drawList");
        List<Map<String, Object>> splineList = (List<Map<String, Object>>) params.get("splineList");
        List<Map<String, Object>> linkLabelList = (List<Map<String, Object>>) params.get("linkLabelList");

        if (!CollectionUtils.isEmpty(linkList)) {
            modeSettingMapper.updateMapBezierCurvePosition(params);
        }
        if (!CollectionUtils.isEmpty(itemList)) {
            modeSettingMapper.updateMapItemPosition(params);
        }
        if (!CollectionUtils.isEmpty(drawList)) {
            for (Map<String, Object> map : drawList) {
                drawToolMapper.updateDrawTool(map);
            }
        }
        if (params.containsKey("digitClockConf") && params.get("digitClockConf") != null) {
            modeSettingMapper.updateDigitClockSetting(params);
        }
        if (!CollectionUtils.isEmpty(splineList)) {
            for (Map<String, Object> map : splineList) {
                drawToolMapper.updateSplineStyle(map);
            }
        }
        if (!CollectionUtils.isEmpty(linkLabelList)) {
            modeSettingMapper.updateMaplinkLabelConf(params);
        }
    }

    public TopoEnvSettingDto getTopoEnvSetting(Map<String, Object> params) {
        params.put("grpNo", 1);
        MapTopoGrpDto grpDto = d3TopoMapper.selectTopoGrpInfo(params);
        if (grpDto == null) {
            modeSettingMapper.insertBaseGrp(params);
        }
        return modeSettingMapper.selectTopoEnvSetting(params);
    }

    @Transactional
    public TopoEnvSettingDto saveTopoEnvSetting(Map<String, Object> params) {
        int existCnt = modeSettingMapper.selectEnvSettingExistCnt(params);
        params.put("existCnt", existCnt);
        modeSettingMapper.updateTopoEnvSetting(params);
        return modeSettingMapper.selectTopoEnvSetting(params);
    }

    @Transactional
    public void addSoundFile(Map<String, Object> params) {
        // TODO: File I/O - save uploaded audio file to storage
        // String fileName = params.get("fileName").toString();
        // Save byte[] params.get("audio") to file path: {uploadPath}/audio/{fileName}

        modeSettingMapper.updateSoundSetting(params);
    }

    public List<TopoItemImgDto> getImgByModelList(Map<String, Object> params) {
        return modeSettingMapper.selectImgByModelList(params);
    }

    @Transactional
    public int saveImgByModel(Map<String, Object> params) {
        return modeSettingMapper.updateImgByModel(params);
    }

    @Transactional
    public int saveImgByModelBatchSet(Map<String, Object> params) {
        return modeSettingMapper.updateImgByModelBatchSet(params);
    }

    @Transactional
    public int saveSplineStyle(Map<String, Object> params) {
        return drawToolMapper.updateSplineStyle(params);
    }

    public Map<String, Object> getTopoSlideSetting(Map<String, Object> params) {
        return modeSettingMapper.selectTopoSlideSetting(params);
    }

    @Transactional
    public String saveTopoSlideSetting(Map<String, Object> params) {
        modeSettingMapper.updateTopoSlideSetting(params);
        return "저장되었습니다.";
    }

    @Transactional
    public String saveHelpLineSetting(Map<String, Object> params) {
        modeSettingMapper.updateHelpLineSetting(params);
        return "저장되었습니다.";
    }
}
