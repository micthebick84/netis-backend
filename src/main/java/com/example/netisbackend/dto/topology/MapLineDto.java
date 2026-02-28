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
public class MapLineDto {
    private long mngNo;
    private long ifIdx;
    private String ifName;
    private String ifAlias;
    private long lineWidth;
    private String status;
}
