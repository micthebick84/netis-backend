package com.example.netisbackend.dto.widget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WidgetSaveRequestDto {
    private String pageKey;
    private String userId;
    private List<WidgetItemDto> items;
}
