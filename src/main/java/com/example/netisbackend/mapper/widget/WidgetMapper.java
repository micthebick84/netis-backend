package com.example.netisbackend.mapper.widget;

import com.example.netisbackend.dto.widget.WidgetBoardDto;
import com.example.netisbackend.dto.widget.WidgetItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WidgetMapper {

    WidgetBoardDto selectBoard(
        @Param("pageKey") String pageKey,
        @Param("userId") String userId
    );

    void insertBoard(WidgetBoardDto board);

    void updateBoardTimestamp(@Param("boardNo") Integer boardNo);

    List<WidgetItemDto> selectItems(@Param("boardNo") Integer boardNo);

    void insertItem(WidgetItemDto item);

    void updateItem(WidgetItemDto item);

    void deleteItem(@Param("itemNo") Integer itemNo);

    void deleteItemsByBoardNo(@Param("boardNo") Integer boardNo);
}
