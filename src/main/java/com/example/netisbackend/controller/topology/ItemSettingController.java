package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.CodeDto;
import com.example.netisbackend.dto.topology.EtcAttrDto;
import com.example.netisbackend.service.topology.ItemSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/item-setting")
@RequiredArgsConstructor
public class ItemSettingController {

    private final ItemSettingService itemSettingService;

    /**
     * 메모 조회
     */
    @PostMapping("/memo")
    public ApiResponse<String> getMemo(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(itemSettingService.getMemo(params));
    }

    /**
     * 임의장비 속성 조회
     */
    @PostMapping("/etc-attr")
    public ApiResponse<EtcAttrDto> getEtcAttr(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(itemSettingService.getEtcAttr(params));
    }

    /**
     * 아이콘 이미지 변경
     */
    @PostMapping("/item-img")
    public ApiResponse<String> editItemImg(@RequestBody Map<String, Object> params) {
        itemSettingService.updateItemImg(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 아이템 정보 변경
     */
    @PostMapping("/item-info")
    public ApiResponse<String> editItemInfo(@RequestBody Map<String, Object> params) {
        itemSettingService.updateItemInfo(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 다중 아이템 정보 변경
     */
    @PostMapping("/multi-item-info")
    public ApiResponse<String> editMultiItemInfo(@RequestBody Map<String, Object> params) {
        itemSettingService.updateMultiItemInfo(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 아이템 정보 초기화
     */
    @PostMapping("/init-item-info")
    public ApiResponse<String> initItemInfo(@RequestBody Map<String, Object> params) {
        itemSettingService.initItemInfo(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 다중 아이템 정보 초기화
     */
    @PostMapping("/init-multi-item-info")
    public ApiResponse<String> initMultiItemInfo(@RequestBody Map<String, Object> params) {
        itemSettingService.initMultiItemInfo(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 배경 이미지 변경
     */
    @PostMapping("/bg-img")
    public ApiResponse<String> editBgImg(@RequestBody Map<String, Object> params) {
        itemSettingService.updateBgImg(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 아이콘 크기 변경
     */
    @PostMapping("/item-size")
    public ApiResponse<String> editItemSize(@RequestBody Map<String, Object> params) {
        itemSettingService.updateItemSize(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 폰트 크기 변경
     */
    @PostMapping("/font-size")
    public ApiResponse<String> editFontSize(@RequestBody Map<String, Object> params) {
        itemSettingService.updateFontSize(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 타입 변경
     */
    @PostMapping("/item-type")
    public ApiResponse<String> editItemType(@RequestBody Map<String, Object> params) {
        itemSettingService.updateItemType(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 별칭 변경
     */
    @PostMapping("/item-alias")
    public ApiResponse<String> editItemAlias(@RequestBody Map<String, Object> params) {
        itemSettingService.updateItemAlias(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 메모 저장
     */
    @PostMapping("/memo/edit")
    public ApiResponse<String> editMemo(@RequestBody Map<String, Object> params) {
        itemSettingService.updateMemo(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 그룹명 변경
     */
    @PostMapping("/grp-name")
    public ApiResponse<String> editGrpName(@RequestBody Map<String, Object> params) {
        itemSettingService.updateGrpName(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 그룹 이동 (아이템의 그룹번호 변경)
     */
    @PostMapping("/grp-no-for-item")
    public ApiResponse<String> editGrpNoForItem(@RequestBody Map<String, Object> params) {
        itemSettingService.updateGrpNoForItem(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 임의장비 속성 변경
     */
    @PostMapping("/etc-attr/edit")
    public ApiResponse<String> editEtcAttr(@RequestBody Map<String, Object> params) {
        itemSettingService.updateEtcAttr(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 그룹 내 명칭표시 ON/OFF
     */
    @PostMapping("/show-label-for-grp")
    public ApiResponse<Integer> editItemShowLabelForGrp(@RequestBody Map<String, Object> params) {
        int updateCnt = itemSettingService.updateItemShowLabelForGrp(params);
        return ApiResponse.success(updateCnt);
    }

    /**
     * URL 템플릿 추가
     */
    @PostMapping("/url-template/add")
    public ApiResponse<String> addUrlSetTemplate(@RequestBody Map<String, Object> params) {
        itemSettingService.addUrlSetTemplate(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * URL 템플릿 조회
     */
    @GetMapping("/url-template")
    public ApiResponse<List<CodeDto>> getUrlTemplate(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(itemSettingService.getUrlTemplate(params));
    }

    /**
     * URL 템플릿 수정
     */
    @PostMapping("/url-template/edit")
    public ApiResponse<String> updateUrlSetTemplate(@RequestBody Map<String, Object> params) {
        itemSettingService.updateUrlTemplate(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * URL 템플릿 삭제
     */
    @PostMapping("/url-template/delete")
    public ApiResponse<String> deleteUrlTemplate(@RequestBody Map<String, Object> params) {
        itemSettingService.deleteUrlTemplate(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 장비 URL 템플릿 지정
     */
    @PostMapping("/dev-url-template")
    public ApiResponse<String> updateDevUrlTemplate(@RequestBody Map<String, Object> params) {
        itemSettingService.updateDevUrlTemplate(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 장비 지정 URL 템플릿 조회
     */
    @GetMapping("/dev-url-template")
    public ApiResponse<List<CodeDto>> getDevUrlTemplate(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(itemSettingService.getDevUrlTemplate(params));
    }

    /**
     * URL 템플릿 호출 조회 (장비정보 치환)
     */
    @PostMapping("/dev-url-template-list")
    public ApiResponse<List<CodeDto>> getDevUrlTemplateList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(itemSettingService.getDevUrlTemplateList(params));
    }

    /**
     * 명칭 위치 변경
     */
    @PostMapping("/label-position")
    public ApiResponse<String> editLabelPosition(@RequestBody Map<String, Object> params) {
        itemSettingService.updateLabelPosition(params);
        return ApiResponse.success("수정되었습니다.");
    }

    /**
     * 연관 기본 그룹 설정
     */
    @PostMapping("/relation-default-grp")
    public ApiResponse<String> editRelationDefaultGrp(@RequestBody Map<String, Object> params) {
        itemSettingService.updateRelationDefaultGrp(params);
        return ApiResponse.success("수정되었습니다.");
    }
}
