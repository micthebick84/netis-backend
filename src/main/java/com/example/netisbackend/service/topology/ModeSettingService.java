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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModeSettingService {

    private final ModeSettingMapper modeSettingMapper;
    private final D3TopoMapper d3TopoMapper;
    private final DrawToolMapper drawToolMapper;

    @Value("${app.upload-path}")
    private String uploadPath;

    public List<ComImgDto> getComImgList(Map<String, Object> params) {
        return modeSettingMapper.selectComImgList(params);
    }

    @Transactional
    public ComImgDto addComImg(Map<String, Object> params) {
        String imgKind2 = params.get("imgKind2").toString();
        String folder = imgKind2.equals("BG") ? "bg" : "micons";
        String imgExt = imgKind2.equals("BG") ? ".png" : ".PNG";
        String fileName = params.get("imgUid").toString() + imgExt;
        String filePath = uploadPath + "/image/d3/";

        Path dirPath = Paths.get(filePath, folder);
        try {
            Files.createDirectories(dirPath);
        } catch (IOException e) {
            log.error("이미지 디렉토리 생성 실패: {}", dirPath, e);
        }

        Path path = Paths.get(filePath + folder, fileName);
        try (OutputStream os = new BufferedOutputStream(
                Files.newOutputStream(path, StandardOpenOption.CREATE_NEW))) {
            os.write((byte[]) params.get("img"));
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException("이미지 파일 업로드 중 에러가 발생하였습니다.", e);
        }

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
        modeSettingMapper.deleteComImg(params);

        String imgKind2 = params.get("imgKind2").toString();
        String folder = imgKind2.equals("BG") ? "bg" : "micons";
        String imgExt = imgKind2.equals("BG") ? ".png" : ".PNG";

        List<Map<String, Object>> imgList = (List<Map<String, Object>>) params.get("imgList");
        if (!CollectionUtils.isEmpty(imgList)) {
            for (Map<String, Object> imgMap : imgList) {
                String fileName = imgMap.get("imgUid").toString() + imgExt;
                Path path = Paths.get(uploadPath + String.format("/image/d3/%s/%s", folder, fileName));
                try {
                    Files.deleteIfExists(path);
                } catch (IOException e) {
                    log.error("이미지 파일 삭제 실패: {}", path, e);
                    throw new RuntimeException("이미지 파일 삭제 중 에러가 발생하였습니다.", e);
                }
            }
        }
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

    private void resolveUserId(Map<String, Object> params) {
        Object userId = params.get("userId");
        if (userId != null) {
            String resolved = d3TopoMapper.resolveUserId(userId.toString());
            if (resolved != null) {
                params.put("userId", resolved);
            }
        }
    }

    public TopoEnvSettingDto getTopoEnvSetting(Map<String, Object> params) {
        resolveUserId(params);
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
        String fileName = params.get("fileName").toString();
        String soundFilePath = uploadPath + "/audio/";

        Path dirPath = Paths.get(soundFilePath);
        try {
            Files.createDirectories(dirPath);
        } catch (IOException e) {
            log.error("오디오 디렉토리 생성 실패: {}", dirPath, e);
        }

        Path path = Paths.get(soundFilePath, fileName);
        try (OutputStream os = new BufferedOutputStream(
                Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING))) {
            os.write((byte[]) params.get("audio"));
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException("오디오 파일 업로드 중 에러가 발생하였습니다.", e);
        }

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
