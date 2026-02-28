package com.example.netisbackend.dto.topology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopoItemRequestDto {
    private String userId;
    private long grpNo;
    private long authGrpNo;
    private int isshare;
    private long sessTopoAuthGrpNo;
    private String auth;
    private List<Integer> evtLvlList;
    private Map<String, String> dynCols;
}
