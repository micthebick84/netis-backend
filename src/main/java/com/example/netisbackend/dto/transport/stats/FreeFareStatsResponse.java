package com.example.netisbackend.dto.transport.stats;

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
public class FreeFareStatsResponse {
    private LocalDate tradeDt;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal freePct;
}
