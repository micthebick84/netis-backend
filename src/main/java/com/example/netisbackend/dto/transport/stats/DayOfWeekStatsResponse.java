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
public class DayOfWeekStatsResponse {
    private Integer dayOfWeekNum;
    private Long avgTotalCnt;
    private Long avgBoardingCnt;
    private Long avgTotalRev;
    private Integer avgFare;
    private BigDecimal avgPaidPct;
}
