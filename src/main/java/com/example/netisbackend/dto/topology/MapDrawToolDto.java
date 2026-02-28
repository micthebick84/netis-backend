package com.example.netisbackend.dto.topology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapDrawToolDto {
    private long drawNo;
    private String userId;
    private long grpNo;
    private String devKind1;
    private String devKind2;
    private double posX;
    private double posY;
    private double width;
    private double height;
    private String fillColor;
    private double fillOpacity;
    private String strokeColor;
    private double strokeOpacity;
    private int strokeWidth;
    private int cornerRadius;
    private int fontSize;
    private String fontWeight;
    private String textAnchor;
    private String textContent;
    private double rx;
    private double ry;
    private int sortIdx;
    private int fontDistance;
    private double rotation;
    private String lineStyle;
    private String drawConf;
}
