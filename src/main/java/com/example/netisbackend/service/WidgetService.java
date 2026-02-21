package com.example.netisbackend.service;

import com.example.netisbackend.dto.widget.WidgetBoardDto;
import com.example.netisbackend.dto.widget.WidgetItemDto;
import com.example.netisbackend.dto.widget.WidgetSaveRequestDto;
import com.example.netisbackend.mapper.widget.WidgetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WidgetService {

    private final WidgetMapper widgetMapper;

    public WidgetBoardDto getBoard(String pageKey, String userId) {
        WidgetBoardDto board = widgetMapper.selectBoard(pageKey, userId);
        if (board != null) {
            List<WidgetItemDto> items = widgetMapper.selectItems(board.getBoardNo());
            board.setItems(items);
        }
        return board;
    }

    @Transactional
    public WidgetBoardDto saveBoard(WidgetSaveRequestDto request) {
        WidgetBoardDto board = widgetMapper.selectBoard(request.getPageKey(), request.getUserId());

        if (board == null) {
            board = WidgetBoardDto.builder()
                    .pageKey(request.getPageKey())
                    .userId(request.getUserId())
                    .build();
            widgetMapper.insertBoard(board);
        } else {
            widgetMapper.updateBoardTimestamp(board.getBoardNo());
        }

        // Delete all existing items and re-insert (simplest approach for bulk save)
        widgetMapper.deleteItemsByBoardNo(board.getBoardNo());

        if (request.getItems() != null) {
            int order = 0;
            for (WidgetItemDto item : request.getItems()) {
                item.setBoardNo(board.getBoardNo());
                item.setSortOrder(order++);
                widgetMapper.insertItem(item);
            }
            board.setItems(request.getItems());
        }

        return board;
    }

    @Transactional
    public void deleteItem(Integer itemNo) {
        widgetMapper.deleteItem(itemNo);
    }
}
