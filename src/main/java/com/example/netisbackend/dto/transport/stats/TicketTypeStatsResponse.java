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
public class TicketTypeStatsResponse {
    private String ticketType;
    private Long totalCnt;
    private Long boardingCnt;
    private Long totalRev;
    private Integer avgFare;
    private BigDecimal avgPaidPct;
}
