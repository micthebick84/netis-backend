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
public class TopoDumpDto {
    private long dumpSeq;
    private String insDate;
    private byte[] xmlText;
    private String memo;
}
