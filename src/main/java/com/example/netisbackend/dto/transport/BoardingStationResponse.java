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
public class BoardingStationResponse {

    private LocalDate tradeDt;
    private String boardingStationNo;
    private Long totalBoardingCnt;
    private BigDecimal usageSharePct;
    private Long totalRev;
    private Integer avgFare;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal paidPct;
    private BigDecimal revenuePerBoarding;
    private BigDecimal revenueSharePct;
}
