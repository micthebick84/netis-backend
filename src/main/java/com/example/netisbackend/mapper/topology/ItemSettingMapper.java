package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.CodeDto;
import com.example.netisbackend.dto.topology.EtcAttrDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemSettingMapper {

    void updateItemSize(Map<String, Object> params);

    void updateFontSize(Map<String, Object> params);

    void updateItemImg(Map<String, Object> params);

    int updateItemInfo(Map<String, Object> params);

    void updateMultiItemInfo(Map<String, Object> params);

    int updateInitItemInfo(Map<String, Object> params);

    void updateInitMultiItemInfo(Map<String, Object> params);

    void updateItemType(Map<String, Object> params);

    void updateItemAlias(Map<String, Object> params);

    void updateGrpName(Map<String, Object> params);

    EtcAttrDto selectEtcAttr(Map<String, Object> params);

    void updateEtcAttr(Map<String, Object> params);

    String selectMemo(Map<String, Object> params);

    void updateMemo(Map<String, Object> params);

    void updateBgImg(Map<String, Object> params);

    void updateGrpNoForItem(Map<String, Object> params);

    int updateItemShowLabelForGrp(Map<String, Object> params);

    void insertUrlSetTemplate(Map<String, Object> params);

    List<CodeDto> selectUrlTemplate(Map<String, Object> params);

    void updateUrlTemplate(Map<String, Object> params);

    void deleteUrlTemplate(Map<String, Object> params);

    void updateDevUrlTemplate(Map<String, Object> params);

    List<CodeDto> selectDevUrlTemplate(Map<String, Object> params);

    List<CodeDto> selectDevUrlTemplateList(Map<String, Object> params);

    void updateLabelPosition(Map<String, Object> params);

    void updateRelationDefaultGrp(Map<String, Object> params);
}
