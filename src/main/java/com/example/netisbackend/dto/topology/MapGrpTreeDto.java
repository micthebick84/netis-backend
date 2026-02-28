package com.example.netisbackend.dto.topology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapGrpTreeDto {
    private long grpNo;
    private String grpName;
    private long grpParent;
    private int childCnt;
    private List<MapGrpTreeDto> children;
}
