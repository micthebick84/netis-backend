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
public class ErrActionDto {
    private long seqNo;
    private String evtName;
    private String engEvtName;
    private String grpName;
    private long sumSec;
    private String errLevel;
    private long mngNo;
    private String devIp;
    private String maintUser;
    private String maintTel;
    private String receiptMemo;
    private String status;
    private String evtCause;
    private String memo;
    private String errType;
    private String errTarget;
}
