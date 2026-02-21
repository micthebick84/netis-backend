package com.example.netisbackend.dto.widget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WidgetItemDto {
    private Integer itemNo;
    private Integer boardNo;
    private String itemTitle;
    private String chartType;
    private Short gridX;
    private Short gridY;
    private Short gridW;
    private Short gridH;
    @JsonProperty("xAxisField")
    private String xAxisField;
    @JsonProperty("yAxisFields")
    private String yAxisFields;  // JSON string
    private String dataApi;
    private Integer sortOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
