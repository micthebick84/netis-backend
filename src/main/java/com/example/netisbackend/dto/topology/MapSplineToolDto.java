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
public class MapSplineToolDto {
    private long splineNo;
    private String userId;
    private long grpNo;
    private String splineType;
    private String splineString;
    private String splineConf;
    private int splineSize;
    private String splineStyle;
    private String splineColor;
    private String itemType;
}
