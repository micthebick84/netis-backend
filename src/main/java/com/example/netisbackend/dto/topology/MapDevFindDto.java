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
public class MapDevFindDto {
    private long grpNo;
    private long itemNo;
    private String grpName;
    private String userDevName;
    private String devName;
    private String devKind2;
    private String devIp;
    private int evtLevel;
}
