package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.TopoDumpDto;
import com.example.netisbackend.dto.topology.TopoRestHistDto;
import com.example.netisbackend.service.topology.DumpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/dump")
@RequiredArgsConstructor
public class DumpController {

    private final DumpService dumpService;

    // ==================== Export / Import ====================

    @GetMapping("/export")
    public ApiResponse<byte[]> exportTopology(@RequestParam String userId) {
        byte[] data = dumpService.exportTopology(userId);
        return ApiResponse.success(data);
    }

    @PostMapping("/import")
    public ApiResponse<String> importTopology(@RequestBody Map<String, Object> params) {
        // TODO: Accept MultipartFile for XML upload when XML parsing is implemented
        String userId = (String) params.get("userId");
        byte[] xmlData = (byte[]) params.get("xmlData");
        dumpService.importTopology(userId, xmlData);
        return ApiResponse.success("가져오기가 완료되었습니다.");
    }

    // ==================== Dump History ====================

    @GetMapping("/list")
    public ApiResponse<List<TopoDumpDto>> getDumpList(@RequestParam String userId) {
        return ApiResponse.success(dumpService.getDumpList(userId));
    }

    @PostMapping("/add")
    public ApiResponse<String> addDump(@RequestBody Map<String, Object> params) {
        String userId = (String) params.get("userId");
        Long grpNo = params.get("grpNo") != null ? Long.parseLong(String.valueOf(params.get("grpNo"))) : null;
        String memo = (String) params.get("memo");
        dumpService.addDump(userId, grpNo, memo);
        return ApiResponse.success("백업이 완료되었습니다.");
    }

    @PostMapping("/restore")
    public ApiResponse<String> restoreFromDump(@RequestBody Map<String, Object> params) {
        String userId = (String) params.get("userId");
        long dumpSeq = Long.parseLong(String.valueOf(params.get("dumpSeq")));
        String sessUserIp = (String) params.get("sessUserIp");
        dumpService.restoreFromDump(userId, dumpSeq, sessUserIp);
        return ApiResponse.success("복원이 완료되었습니다.");
    }

    // ==================== Restore History ====================

    @GetMapping("/restore-hist")
    public ApiResponse<List<TopoRestHistDto>> getRestoreHist(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(dumpService.getRestoreHist(params));
    }
}
