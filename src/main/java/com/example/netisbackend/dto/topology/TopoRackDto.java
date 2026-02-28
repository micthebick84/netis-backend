package com.example.netisbackend.dto.topology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopoRackDto {
    private long grpNo;
    private long itemNo;
    private Long rackNo;
    private String rackName;
    private String rackType;
    private int xPoint;
    private int yPoint;
    private int rackUnit;
    private String rackWidth;
    private String rackHeight;
    private String ymd;
    private String rackDesc;
    private String rackIp;
    private int rackPort;
    private String model;
    private String vendor;
    private int evtLevel;
    private List<TopoRackSlotDto> topoRackSlotList;
}
