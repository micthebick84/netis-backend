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
public class MapRegSensorDto {
    private String grpName;
    private String parentName;
    private String devName;
    private long mngNo;
    private String parentIp;
    private String devIp;
    private long fmsSeqNo;
    private int portNo;
    private String vendor;
    private String sensorModel;
    private String sensorIndex;
    private String sensorName;
    private String sensorKind;
    private String setupLoc;
    private String status;
    private String isExist;
    private String devKind1;
    private String devKind2;
}
