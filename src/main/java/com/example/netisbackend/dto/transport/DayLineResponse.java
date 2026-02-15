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
public class DayLineResponse {

    private LocalDate tradeDt;
    private Integer dayOfWeekNum;
    private String dayOfWeekName;
    private Integer lineNo;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private Long totalRev;
    private Integer avgFare;
    private Long paidCnt;
    private Long freeCnt;
    private BigDecimal paidPct;
}
