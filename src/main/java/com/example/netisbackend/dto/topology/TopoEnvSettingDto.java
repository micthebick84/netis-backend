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
public class TopoEnvSettingDto {
    private long refreshTime;
    private int showLabel;
    private String lineColor;
    private String pollingColor;
    private String fontColor;
    private String fontBgColor;
    private int alarmChk;
    private int alarmLv1Chk;
    private int alarmLv2Chk;
    private int alarmLv3Chk;
    private int alarmLv4Chk;
    private int alarmLv5Chk;
    private String alarmLv1Path;
    private String alarmLv2Path;
    private String alarmLv3Path;
    private String alarmLv4Path;
    private String alarmLv5Path;
    private String jsonConf;
    private int showIcmpPoll;
    private int showApEvent;
    private int showVmEvent;
    private String digitClockConf;
    private String slideGrpConf;
    private String helpLineConf;
}
