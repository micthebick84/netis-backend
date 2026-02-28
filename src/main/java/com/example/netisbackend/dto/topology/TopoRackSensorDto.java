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
public class TopoRackSensorDto {
    private Long rackNo;
    private String rackName;
    private long grpNo;
    private String grpName;
    private int fmsSeqNo;
    private long mngNo;
    private int sensorId;
    private String sensorName;
    private String sensorKind;
    private int xPoint;
    private int yPoint;
    private String evtLevel;
    private String evtLevelStr;
    private String evtLevelColor;
    private String sensorValue;
}
