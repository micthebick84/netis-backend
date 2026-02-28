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
public class MapRegDbmsDto {
    private long mngNo;
    private long dbmsNo;
    private String devName;
    private String dbmsNm;
    private String devIp;
    private String grpName;
    private String displayName;
    private int dbmsPort;
    private String dbmsKind;
    private String isExist;
    private String vendor;
    private String model;
}
