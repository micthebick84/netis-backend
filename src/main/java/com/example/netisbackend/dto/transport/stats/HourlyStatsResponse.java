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
public class HourlyStatsResponse {
    private Integer hourRange;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private BigDecimal avgUsagePct;
    private Long totalRev;
    private Integer avgFare;
}
