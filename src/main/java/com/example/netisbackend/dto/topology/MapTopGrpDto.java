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
public class MapTopGrpDto {
    private long grpNo;
    private long grpParent;
    private String grpParentNm;
    private String grpName;
    private String parentId;
    private String userId;
    private int isShare;
    private int cnt;
    private String itemName;
    private int xpoint;
    private int ypoint;
    private long itemNo;
    private long mngNo;
    private String devKind1;
    private String devKind2;
    private String usrKind;
    private double itemSize;
    private String devIp;
    private String itemAlias;
    private int fontSize;
    private int evtLevel;
    private long engNo;
    private int evtType;
    private int childCnt;
    private String temp1;
    private String temp2;
    private String temp3;
    private String userContent;
    private String haStatus;
    private int showLabel;
    private String dynInfo;
    private String location;
    private int icmpPoll;
    private String itemConf;
}
