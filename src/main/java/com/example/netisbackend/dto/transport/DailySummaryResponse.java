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
public class DailySummaryResponse {

    private LocalDate tradeDt;
    private Integer dayOfWeekNum;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private Integer stationCnt;
    private Integer routeCnt;
    private Long totalRev;
    private Integer avgFare;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal paidPct;
    private BigDecimal boardingPct;
    private BigDecimal revenuePerTransaction;
    private BigDecimal avgTransactionsPerStation;
    private BigDecimal avgTransactionsPerRoute;
}
