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
public class DateTicketResponse {

    private LocalDate tradeDt;
    private String ticketType;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private Long totalRev;
    private Integer avgFare;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal paidPct;
}
