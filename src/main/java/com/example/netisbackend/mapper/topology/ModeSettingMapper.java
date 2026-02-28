package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.ComImgDto;
import com.example.netisbackend.dto.topology.ErrActionDto;
import com.example.netisbackend.dto.topology.TopoEnvSettingDto;
import com.example.netisbackend.dto.topology.TopoItemImgDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ModeSettingMapper {

    List<ComImgDto> selectComImgList(Map<String, Object> params);

    ComImgDto selectComImgInfo(Map<String, Object> params);

    void insertComImg(Map<String, Object> params);

    void updateComImg(Map<String, Object> params);

    void deleteComImg(Map<String, Object> params);

    void updateBgImg(Map<String, Object> params);

    List<ErrActionDto> selectErrActionList(Map<String, Object> params);

    void updateErrAction(Map<String, Object> params);

    void updateAllErrAction(Map<String, Object> params);

    void procEventProc();

    void updateMapBezierCurvePosition(Map<String, Object> params);

    void updateMapItemPosition(Map<String, Object> params);

    // Environment settings
    TopoEnvSettingDto selectTopoEnvSetting(Map<String, Object> params);

    int selectEnvSettingExistCnt(Map<String, Object> params);

    void updateTopoEnvSetting(Map<String, Object> params);

    void updateSoundSetting(Map<String, Object> params);

    void insertBaseGrp(Map<String, Object> params);

    // Image management by model
    List<TopoItemImgDto> selectImgByModelList(Map<String, Object> params);

    int updateImgByModel(Map<String, Object> params);

    int updateImgByModelBatchSet(Map<String, Object> params);

    // DigitClock settings
    void updateDigitClockSetting(Map<String, Object> params);

    void updateTopoSlideSetting(Map<String, Object> params);

    void updateMaplinkLabelConf(Map<String, Object> params);

    Map<String, Object> selectTopoSlideSetting(Map<String, Object> params);

    // HelpLine settings
    void updateHelpLineSetting(Map<String, Object> params);
}
