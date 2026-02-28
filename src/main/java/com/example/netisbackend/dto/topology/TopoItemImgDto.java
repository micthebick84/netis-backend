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
public class TopoItemImgDto {
    private long seqNo;
    private String devKind1;
    private String devKind2;
    private String model;
    private String imgFileNm;
    private String imgName;
    private String imgKind3;
}
