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
public class EtcAttrDto {
    private long itemNo;
    private String userId;
    private String devName;
    private String devIp;
    private String url;
    private String icmpPolling;
}
