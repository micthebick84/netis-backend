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
public class MapRegApDto {
    private long parentMngNo;
    private String devName;
    private String grpName;
    private long mngNo;
    private String apName;
    private String apIp;
    private String apMac;
    private String isExist;
}
