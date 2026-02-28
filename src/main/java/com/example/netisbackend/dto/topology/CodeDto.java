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
public class CodeDto {
    private long codeId;
    private String codeValue1;
    private String codeValue2;
    private String codeValue3;
    private String codeValue4;
    private String codeValue5;
    private String codeValue6;
    private String codeValue7;
    private String codeValue8;
    private String memo;
    private int num;
}
