package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.ComImgDto;
import com.example.netisbackend.dto.topology.ErrActionDto;
import com.example.netisbackend.dto.topology.TopoEnvSettingDto;
import com.example.netisbackend.dto.topology.TopoItemImgDto;
import com.example.netisbackend.service.topology.ModeSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/topology/mode-setting")
@RequiredArgsConstructor
public class ModeSettingController {

    private final ModeSettingService modeSettingService;

    // ==================== Image Management ====================

    @PostMapping("/com-img-list")
    public ApiResponse<List<ComImgDto>> getComImgList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.getComImgList(params));
    }

    @PostMapping("/file-upload")
    public ApiResponse<ComImgDto> fileUpload(
            @RequestParam("fileinput") MultipartFile multipartFile,
            @RequestParam Map<String, Object> params) {
        try {
            byte[] imgBytes = multipartFile.getBytes();
            String imgUid = String.format("UID_%s_%s", params.get("imgName"), UUID.randomUUID());

            Map<String, Object> criterion = new HashMap<>(params);
            criterion.put("imgUid", imgUid);
            criterion.put("img", imgBytes);

            return ApiResponse.success(modeSettingService.addComImg(criterion));
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    @PostMapping("/save-com-img")
    public ApiResponse<Void> saveComImg(@RequestBody Map<String, Object> params) {
        modeSettingService.saveComImg(params);
        return ApiResponse.success(null);
    }

    @PostMapping("/del-com-img")
    public ApiResponse<Void> delComImg(@RequestBody Map<String, Object> params) {
        modeSettingService.delComImg(params);
        return ApiResponse.success(null);
    }

    // ==================== Error Action ====================

    @PostMapping("/err-action-list")
    public ApiResponse<List<ErrActionDto>> getErrActionList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.getErrActionList(params));
    }

    @PostMapping("/save-err-action")
    public ApiResponse<String> saveErrAction(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveErrAction(params));
    }

    @PostMapping("/save-all-err-action")
    public ApiResponse<String> saveAllErrAction(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveAllErrAction(params));
    }

    // ==================== Map Position ====================

    @PostMapping("/save-map-position")
    public ApiResponse<Void> saveMapPosition(@RequestBody Map<String, Object> params) {
        modeSettingService.saveMapPosition(params);
        return ApiResponse.success(null);
    }

    // ==================== Environment Settings ====================

    @GetMapping("/topo-env-setting")
    public ApiResponse<TopoEnvSettingDto> getTopoEnvSetting(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.getTopoEnvSetting(params));
    }

    @PostMapping("/save-topo-env-setting")
    public ApiResponse<TopoEnvSettingDto> saveTopoEnvSetting(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveTopoEnvSetting(params));
    }

    @PostMapping("/mp3-upload")
    public ApiResponse<Void> mp3Upload(
            @RequestParam("fileinputs") List<MultipartFile> multipartFiles,
            @RequestParam Map<String, Object> params) {
        try {
            Map<String, Object> criterion = new HashMap<>(params);
            for (MultipartFile file : multipartFiles) {
                byte[] audioBytes = file.getBytes();
                criterion.put("audio", audioBytes);
                criterion.put("fileName", params.get("fileName"));
                criterion.put("fileIdx", params.get("fileIdx"));
            }
            modeSettingService.addSoundFile(criterion);
            return ApiResponse.success(null);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    // ==================== Model Image ====================

    @PostMapping("/img-by-model-list")
    public ApiResponse<List<TopoItemImgDto>> getImgByModelList(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.getImgByModelList(params));
    }

    @PostMapping("/save-img-by-model")
    public ApiResponse<Integer> saveImgByModel(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveImgByModel(params));
    }

    @PostMapping("/save-img-by-model-batch-set")
    public ApiResponse<Integer> saveImgByModelBatchSet(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveImgByModelBatchSet(params));
    }

    // ==================== Spline Style ====================

    @PostMapping("/save-spline-style")
    public ApiResponse<Integer> saveSplineStyle(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveSplineStyle(params));
    }

    // ==================== Slide Show ====================

    @GetMapping("/topo-slide-setting")
    public ApiResponse<Map<String, Object>> getTopoSlideSetting(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.getTopoSlideSetting(params));
    }

    @PostMapping("/save-topo-slide-setting")
    public ApiResponse<String> saveTopoSlideSetting(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveTopoSlideSetting(params));
    }

    // ==================== HelpLine ====================

    @PostMapping("/save-helpline-setting")
    public ApiResponse<String> saveHelpLineSetting(@RequestBody Map<String, Object> params) {
        return ApiResponse.success(modeSettingService.saveHelpLineSetting(params));
    }
}
