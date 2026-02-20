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
public class StationImbalanceStatsResponse {
    private String stationNo;
    private Long totalBoardingCnt;
    private Long totalAlightingCnt;
    private Long netPassengerFlow;
    private BigDecimal avgDiffPct;
}
