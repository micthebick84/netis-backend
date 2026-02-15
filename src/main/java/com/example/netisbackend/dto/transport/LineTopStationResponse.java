package com.example.netisbackend.dto.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineTopStationResponse {

    private LocalDate tradeDt;
    private Integer lineNo;
    private String stationNo;
    private Integer stationRank;
    private Long totalCnt;
    private Long boardingCnt;
    private Long alightingCnt;
    private Long totalRev;
    private Integer avgFare;
}
