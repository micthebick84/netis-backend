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
public class HourTicketResponse {

    private LocalDate tradeDt;
    private Integer hourRange;
    private String ticketType;
    private Long boardingCnt;
    private Long totalRev;
    private Integer avgFare;
}
