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
public class TopoRackSlotDto {
    private Long rackNo;
    private String rackSection;
    private int slotNo;
    private int slotU;
    private String grpName;
    private long mngNo;
    private String devName;
    private String devIp;
    private String devKind1;
    private String devKind2;
    private String vendor;
    private String model;
    private String evtLevel;
    private String imgName;
    private String slotKind;
}
