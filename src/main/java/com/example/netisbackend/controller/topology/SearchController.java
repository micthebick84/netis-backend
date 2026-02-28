package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.topology.LinkViewDto;
import com.example.netisbackend.dto.topology.MapDevFindDto;
import com.example.netisbackend.dto.topology.MapGrpViewDto;
import com.example.netisbackend.service.topology.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topology/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    /**
     * 장비찾기 목록 조회
     */
    @GetMapping("/devFind")
    public ApiResponse<List<MapDevFindDto>> getDevFindList(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(searchService.getDevFindList(params));
    }

    /**
     * 그룹 조회 (토폴로지 그룹 트리)
     */
    @GetMapping("/grpView")
    public ApiResponse<List<MapGrpViewDto>> getGrpViewList(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(searchService.getGrpViewList(params));
    }

    /**
     * 등록 그룹 조회
     */
    @GetMapping("/regGrpView")
    public ApiResponse<List<MapGrpViewDto>> getRegGrpViewList(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(searchService.getRegGrpViewList(params));
    }

    /**
     * 폴링 링크 목록 조회
     */
    @GetMapping("/pollingLink")
    public ApiResponse<List<LinkViewDto>> getPollingLinkList(@RequestParam Map<String, Object> params) {
        return ApiResponse.success(searchService.getPollingLinkList(params));
    }
}
