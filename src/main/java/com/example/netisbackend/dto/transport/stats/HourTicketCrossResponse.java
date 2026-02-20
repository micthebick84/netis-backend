package com.example.netisbackend.dto.transport.stats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HourTicketCrossResponse {
    private Integer hourRange;
    private String ticketType;
    private Long boardingCnt;
    private Long totalRev;
    private Integer avgFare;
}
