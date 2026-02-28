package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.*;
import com.example.netisbackend.service.topology.ItemAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/item-add")
@RequiredArgsConstructor
public class ItemAddController {

    private final ItemAddService itemAddService;

    // ==================== 그룹 ====================

    @PostMapping("/grp")
    public ApiResponse<String> addGrp(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addGrp(reqMap);
        return ApiResponse.success("OK");
    }

    @PostMapping("/copy-grp")
    public ApiResponse<String> addCopyGrp(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addCopyGrp(reqMap);
        return ApiResponse.success("OK");
    }

    @PostMapping("/clone-grp")
    public ApiResponse<String> addCloneGrp(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addCloneGrp(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== 장비 ====================

    @GetMapping("/reg-dev-list")
    public ApiResponse<List<MapRegDevDto>> getRegDevList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegDevList(reqMap));
    }

    @PostMapping("/dev")
    public ApiResponse<String> addDev(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addDev(reqMap);
        return ApiResponse.success("OK");
    }

    @PostMapping("/copy-dev")
    public ApiResponse<String> addCopyDev(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addCopyDev(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== 서버 ====================

    @GetMapping("/reg-svr-list")
    public ApiResponse<List<MapRegSvrDto>> getRegSvrList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegSvrList(reqMap));
    }

    @PostMapping("/svr")
    public ApiResponse<String> addSvr(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addSvr(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== 서브넷 ====================

    @GetMapping("/reg-sub-list")
    public ApiResponse<List<MapRegSubDto>> getRegSubList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegSubList(reqMap));
    }

    @PostMapping("/sub")
    public ApiResponse<String> addSub(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addSub(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== 임의장비 ====================

    @PostMapping("/etc")
    public ApiResponse<String> addEtc(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addEtc(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== RACK ====================

    @GetMapping("/reg-rack-list")
    public ApiResponse<List<MapRegRackDto>> getRegRackList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegRackList(reqMap));
    }

    @PostMapping("/rack")
    public ApiResponse<String> addRack(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addRack(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== AP ====================

    @GetMapping("/reg-ap-list")
    public ApiResponse<List<MapRegApDto>> getRegApList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegApList(reqMap));
    }

    @PostMapping("/ap")
    public ApiResponse<String> addAp(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addAp(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== 센서 ====================

    @GetMapping("/reg-sensor-list")
    public ApiResponse<List<MapRegSensorDto>> getRegSensorList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegSensorList(reqMap));
    }

    @PostMapping("/sensor")
    public ApiResponse<String> addSensor(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addSensor(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== WAS ====================

    @GetMapping("/reg-was-list")
    public ApiResponse<List<MapRegWasDto>> getRegWasList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegWasList(reqMap));
    }

    @PostMapping("/was")
    public ApiResponse<String> addWas(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addWas(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== DBMS ====================

    @GetMapping("/reg-dbms-list")
    public ApiResponse<List<MapRegDbmsDto>> getRegDbmsList(@RequestParam Map<String, Object> reqMap) {
        return ApiResponse.success(itemAddService.getRegDbmsList(reqMap));
    }

    @PostMapping("/dbms")
    public ApiResponse<String> addDbms(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addDbms(reqMap);
        return ApiResponse.success("OK");
    }

    // ==================== 일괄추가 ====================

    @PostMapping("/measure-multi-dev")
    public ApiResponse<String> addMeasureMultiDev(@RequestBody Map<String, Object> reqMap) {
        itemAddService.addMeasureMultiDev(reqMap);
        return ApiResponse.success("OK");
    }
}
