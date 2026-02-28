package com.example.netisbackend.service.topology;

import com.example.netisbackend.dto.topology.CodeDto;
import com.example.netisbackend.dto.topology.EtcAttrDto;
import com.example.netisbackend.mapper.topology.ItemSettingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemSettingService {

    private final ItemSettingMapper itemSettingMapper;

    /**
     * 아이콘 크기 변경
     */
    @Transactional
    public void updateItemSize(Map<String, Object> params) {
        itemSettingMapper.updateItemSize(params);
    }

    /**
     * 폰트 크기 변경
     */
    @Transactional
    public void updateFontSize(Map<String, Object> params) {
        itemSettingMapper.updateFontSize(params);
    }

    /**
     * 아이콘 이미지 변경
     */
    @Transactional
    public void updateItemImg(Map<String, Object> params) {
        itemSettingMapper.updateItemImg(params);
    }

    /**
     * 아이템 정보 변경
     */
    @Transactional
    public void updateItemInfo(Map<String, Object> params) {
        itemSettingMapper.updateItemInfo(params);

        // 그룹명 수정시 grpNo를 -1로 설정하여 토폴로지맵 표시 이상 방지
        if ("GRP".equals(params.get("devKind1"))) {
            params.put("grpNo", -1);
        }
    }

    /**
     * 다중 아이템 정보 변경
     */
    @Transactional
    public void updateMultiItemInfo(Map<String, Object> params) {
        itemSettingMapper.updateMultiItemInfo(params);
    }

    /**
     * 아이템 정보 초기화
     */
    @Transactional
    public void initItemInfo(Map<String, Object> params) {
        List<String> jsonKeyList = buildJsonKeyList(params);
        params.put("jsonKeyList", jsonKeyList);
        itemSettingMapper.updateInitItemInfo(params);
    }

    /**
     * 다중 아이템 정보 초기화
     */
    @Transactional
    public void initMultiItemInfo(Map<String, Object> params) {
        List<String> jsonKeyList = buildJsonKeyList(params);
        params.put("jsonKeyList", jsonKeyList);
        itemSettingMapper.updateInitMultiItemInfo(params);
    }

    /**
     * 타입 변경
     */
    @Transactional
    public void updateItemType(Map<String, Object> params) {
        itemSettingMapper.updateItemType(params);
    }

    /**
     * 별칭 변경
     */
    @Transactional
    public void updateItemAlias(Map<String, Object> params) {
        itemSettingMapper.updateItemAlias(params);
    }

    /**
     * 그룹명 변경
     */
    @Transactional
    public void updateGrpName(Map<String, Object> params) {
        itemSettingMapper.updateGrpName(params);
    }

    /**
     * 임의장비 속성 조회
     */
    public EtcAttrDto getEtcAttr(Map<String, Object> params) {
        return itemSettingMapper.selectEtcAttr(params);
    }

    /**
     * 임의장비 속성 변경
     */
    @Transactional
    public void updateEtcAttr(Map<String, Object> params) {
        itemSettingMapper.updateEtcAttr(params);
    }

    /**
     * 메모 조회
     */
    public String getMemo(Map<String, Object> params) {
        return itemSettingMapper.selectMemo(params);
    }

    /**
     * 메모 저장
     */
    @Transactional
    public void updateMemo(Map<String, Object> params) {
        itemSettingMapper.updateMemo(params);
    }

    /**
     * 배경 이미지 변경
     */
    @Transactional
    public void updateBgImg(Map<String, Object> params) {
        itemSettingMapper.updateBgImg(params);
    }

    /**
     * 그룹 이동 (아이템의 그룹번호 변경)
     */
    @Transactional
    public void updateGrpNoForItem(Map<String, Object> params) {
        itemSettingMapper.updateGrpNoForItem(params);
    }

    /**
     * 그룹 내 명칭표시 ON/OFF
     */
    @Transactional
    public int updateItemShowLabelForGrp(Map<String, Object> params) {
        return itemSettingMapper.updateItemShowLabelForGrp(params);
    }

    /**
     * URL 템플릿 추가
     */
    @Transactional
    public void addUrlSetTemplate(Map<String, Object> params) {
        itemSettingMapper.insertUrlSetTemplate(params);
    }

    /**
     * URL 템플릿 조회
     */
    public List<CodeDto> getUrlTemplate(Map<String, Object> params) {
        return itemSettingMapper.selectUrlTemplate(params);
    }

    /**
     * URL 템플릿 수정
     */
    @Transactional
    public void updateUrlTemplate(Map<String, Object> params) {
        itemSettingMapper.updateUrlTemplate(params);
    }

    /**
     * URL 템플릿 삭제
     */
    @Transactional
    public void deleteUrlTemplate(Map<String, Object> params) {
        itemSettingMapper.deleteUrlTemplate(params);
    }

    /**
     * 장비 URL 템플릿 지정
     */
    @Transactional
    public void updateDevUrlTemplate(Map<String, Object> params) {
        itemSettingMapper.updateDevUrlTemplate(params);
    }

    /**
     * 장비 지정 URL 템플릿 조회
     */
    public List<CodeDto> getDevUrlTemplate(Map<String, Object> params) {
        return itemSettingMapper.selectDevUrlTemplate(params);
    }

    /**
     * URL 템플릿 호출 조회 (장비정보 치환)
     */
    public List<CodeDto> getDevUrlTemplateList(Map<String, Object> params) {
        return itemSettingMapper.selectDevUrlTemplateList(params);
    }

    /**
     * 명칭 위치 변경
     */
    @Transactional
    public void updateLabelPosition(Map<String, Object> params) {
        itemSettingMapper.updateLabelPosition(params);
    }

    /**
     * 연관 기본 그룹 설정
     */
    @Transactional
    public void updateRelationDefaultGrp(Map<String, Object> params) {
        itemSettingMapper.updateRelationDefaultGrp(params);
    }

    /**
     * 초기화 대상 JSON 키 목록 생성
     */
    private List<String> buildJsonKeyList(Map<String, Object> params) {
        List<String> jsonKeyList = new ArrayList<>();
        Object fontColor = params.get("fontColor");
        Object fontBgColor = params.get("fontBgColor");
        Object fontBgOpacity = params.get("fontBgOpacity");

        if (fontColor != null && toInt(fontColor) == 1) {
            jsonKeyList.add("labelColor");
        }
        if (fontBgColor != null && toInt(fontBgColor) == 1) {
            jsonKeyList.add("labelBgColor");
        }
        if (fontBgOpacity != null && toInt(fontBgOpacity) == 1) {
            jsonKeyList.add("labelBgOpacity");
        }
        return jsonKeyList;
    }

    private int toInt(Object value) {
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return Integer.parseInt(String.valueOf(value));
    }
}
