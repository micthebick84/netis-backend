package com.example.netisbackend.dto.topology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GisItemDto {
    private long itemNo;
    private long mngNo;
    private String devKind1;
    private String devKind2;
    private String lat;
    private String lnt;
}
