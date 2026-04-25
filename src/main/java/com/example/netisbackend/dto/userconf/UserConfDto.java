package com.example.netisbackend.dto.userconf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserConfDto {
    private String userId;
    private String userName;
    private String deptName;
    private String cellTel;
    private String email;
    private String userPcIp;
    private Integer useFlag;
    private Integer isRecvSms;
    private Integer isRecvEmail;
    private String auth;
    private LocalDateTime passDate;
    private LocalDateTime passChgDate;
}
