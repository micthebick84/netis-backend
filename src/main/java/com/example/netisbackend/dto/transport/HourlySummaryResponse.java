package com.example.netisbackend.dto.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HourlySummaryResponse {

    private LocalDate tradeDt;
    private Integer hourRange;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private BigDecimal hourUsagePct;
    private Long totalRev;
    private Integer avgFare;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal paidPct;
    private BigDecimal boardingPct;
    private BigDecimal revenueSharePct;
}
