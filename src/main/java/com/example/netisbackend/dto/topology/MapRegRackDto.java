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
public class MapRegRackDto {
    private long grpNo;
    private String grpName;
    private long rackNo;
    private String rackName;
    private int rackU;
    private String rackType;
    private String vendor;
    private String model;
    private String ymd;
    private String width;
    private String height;
    private String isexist;
}
