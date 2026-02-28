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
public class MapRegDevDto {
    private long grpNo;
    private String grpName;
    private long mngNo;
    private String devName;
    private String devIp;
    private String devKind1;
    private String devKind2;
    private String devKind2Str;
    private String community;
    private String model;
    private String vendor;
    private String vendorStr;
    private String isExist;
}
