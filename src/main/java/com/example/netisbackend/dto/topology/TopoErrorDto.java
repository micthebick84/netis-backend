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
public class TopoErrorDto {
    private String ymdhms;
    private int evtLevel;
    private String evtLevelStr;
    private String evtName;
    private String srcType;
    private String srcTypeStr;
    private String srcInfo;
    private long itemNo;
    private long grpNo;
    private String grpName;
    private long mngNo;
    private String devIp;
    private String userDevName;
    private String devName;
    private String devKind1;
    private String pathName;
    private Long rackNo;
}
