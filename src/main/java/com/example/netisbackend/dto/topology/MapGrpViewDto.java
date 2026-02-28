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
public class MapGrpViewDto {
    private long grpNo;
    private String grpName;
    private int evtLevel;
    private long grpParent;
    private List<MapGrpViewDto> children;
}
