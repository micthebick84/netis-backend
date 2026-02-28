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
public class MapRegSubDto {
    private long subNo;
    private String subName;
    private String ip;
    private int subMaskNo;
    private String grpName;
    private String isExist;
}
