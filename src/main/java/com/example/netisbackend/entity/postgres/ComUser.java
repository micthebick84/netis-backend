package com.example.netisbackend.entity.postgres;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "com_user")
@Getter
@Setter
@NoArgsConstructor
public class ComUser {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "pos_name")
    private String posName;

    @Column
    private String email;

    @Column(name = "office_tel")
    private String officeTel;

    @Column(name = "cell_tel")
    private String cellTel;

    @Column
    private String auth;

    @Column(name = "use_flag")
    private Short useFlag;

    @Column(name = "dev_grp_no")
    private Integer devGrpNo;

    @Column(name = "auth_grp_no")
    private Integer authGrpNo;

    @Column
    private Short manage;

    @Column(name = "parent_id")
    private String parentId;

    @Column
    private String account;

    @Column(name = "netis_web_theme")
    private String netisWebTheme;

    @Column(name = "netis_web_menu_min")
    private String netisWebMenuMin;

    @Column(name = "dashboard_auth")
    private String dashboardAuth;

    @Column(name = "pass_date")
    private LocalDateTime passDate;

    @Column(name = "pass_err_cnt")
    private Integer passErrCnt;

    @Column(name = "pass_chg_date")
    private LocalDateTime passChgDate;

    @Column(name = "menu_auth_no")
    private Integer menuAuthNo;
}
