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
public class MapRegWasDto {
    private long mngNo;
    private long wasNo;
    private String devName;
    private String wasNm;
    private String devIp;
    private String grpName;
    private String displayName;
    private int connPort;
    private String wasKind;
    private String isExist;
    private String vendor;
    private String model;
}
