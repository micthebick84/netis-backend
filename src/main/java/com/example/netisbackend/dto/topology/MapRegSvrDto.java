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
public class MapRegSvrDto {
    private long mngNo;
    private String devName;
    private String devIp;
    private String grpName;
    private long svrNo;
    private String name;
    private long ipNo;
    private String displayName;
    private int port;
    private int frPort;
    private String devKind1;
    private String devKind2;
    private String devKind2Str;
    private String isExist;
    private String vendor;
    private String vendorStr;
    private String model;
}
