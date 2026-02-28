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
public class TopoRestHistDto {
    private String insDate;
    private long dumpSeq;
    private String restDate;
    private String memo;
    private String restUserId;
    private String restUserNm;
    private String restUserIp;
}
