package com.example.netisbackend.dto.transport.stats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteEfficiencyStatsResponse {
    private String routeNo;
    private Long totalCnt;
    private Long totalRev;
    private BigDecimal avgRevPerTransaction;
    private BigDecimal avgRevPerStation;
    private BigDecimal avgTransPerStation;
    private BigDecimal avgBoardAlightRatio;
}
