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
public class MapDevDto {
    private long mngNo;
    private String devName;
    private String devIp;
    private String devKind1;
    private String devKind2;
    private String devType;
    private String devKind1Str;
    private String devKind2Str;
}
