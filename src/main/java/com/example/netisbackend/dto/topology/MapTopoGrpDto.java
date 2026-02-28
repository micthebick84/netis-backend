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
public class MapTopoGrpDto {
    private long grpNo;
    private long grpParent;
    private String grpParentNm;
    private String grpName;
    private String bgFileNm;
    private String viewType;
    private long evtLevelCnt1;
    private long evtLevelCnt2;
    private long evtLevelCnt3;
    private long evtLevelCnt4;
    private long evtLevelCnt5;
    private String pathName;
}
