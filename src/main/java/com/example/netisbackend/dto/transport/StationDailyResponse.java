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
public class StationDailyResponse {

    private LocalDate tradeDt;
    private String stationNo;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private BigDecimal boardingAlightingDiffPct;
    private Long netPassengerFlow;
    private Integer avgFare;
    private Long totalRev;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal boardingPct;
    private BigDecimal alightingPct;
    private BigDecimal paidPct;
}
