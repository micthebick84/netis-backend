package com.example.netisbackend.controller;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.widget.WidgetBoardDto;
import com.example.netisbackend.dto.widget.WidgetSaveRequestDto;
import com.example.netisbackend.service.WidgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/widget")
@RequiredArgsConstructor
public class WidgetController {

    private final WidgetService widgetService;

    @GetMapping("/board")
    public ApiResponse<WidgetBoardDto> getBoard(
            @RequestParam String pageKey,
            @RequestParam String userId) {
        WidgetBoardDto board = widgetService.getBoard(pageKey, userId);
        return ApiResponse.success(board);
    }

    @PostMapping("/board")
    public ApiResponse<WidgetBoardDto> saveBoard(@RequestBody WidgetSaveRequestDto request) {
        WidgetBoardDto board = widgetService.saveBoard(request);
        return ApiResponse.success("저장되었습니다.", board);
    }

    @DeleteMapping("/items/{itemNo}")
    public ApiResponse<Void> deleteItem(@PathVariable Integer itemNo) {
        widgetService.deleteItem(itemNo);
        return ApiResponse.success(null);
    }
}
