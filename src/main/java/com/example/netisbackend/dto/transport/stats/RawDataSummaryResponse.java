package com.example.netisbackend.dto.transport.stats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawDataSummaryResponse {
    private Long totalCnt;
    private Long tradeDateCnt;
    private Long stationCnt;
    private Long routeCnt;
    private Long cardCnt;
}
