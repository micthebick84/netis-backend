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
public class CardDailyResponse {

    private LocalDate tradeDt;
    private String cardType;
    private Long totalCnt;
    private Integer avgFare;
    private Long totalRev;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal paidPct;
}
