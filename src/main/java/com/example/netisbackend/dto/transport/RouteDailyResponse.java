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
public class RouteDailyResponse {

    private LocalDate tradeDt;
    private String routeNo;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private Integer stationCnt;
    private BigDecimal usageSharePct;
    private Long totalRev;
    private Integer avgFare;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal paidPct;
    private BigDecimal revenuePerTransaction;
    private BigDecimal revenueSharePct;
    private BigDecimal revenuePerStation;
    private BigDecimal avgTransactionsPerStation;
    private BigDecimal boardingAlightingRatio;
}
