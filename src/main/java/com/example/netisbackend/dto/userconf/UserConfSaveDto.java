package com.example.netisbackend.dto.userconf;

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
public class UserConfSaveDto {
    private String userId;
    private String password;
    private String userName;
    private String deptName;
    private String cellTel;
    private String email;
    private String userPcIp;
    private Integer useFlag;
    private Integer isRecvSms;
    private Integer isRecvEmail;
    private String auth;
    private String pwSalt;
}
