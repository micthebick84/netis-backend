package com.example.netisbackend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComUserResponse {

    private String userId;
    private String userName;
    private String deptName;
    private String posName;
    private String email;
    private String officeTel;
    private String cellTel;
    private String auth;
    private Short useFlag;
    private Integer menuAuthNo;
}
