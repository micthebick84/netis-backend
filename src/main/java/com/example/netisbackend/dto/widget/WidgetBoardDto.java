package com.example.netisbackend.dto.widget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WidgetBoardDto {
    private Integer boardNo;
    private String pageKey;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<WidgetItemDto> items;
}
