package com.example.netisbackend.dto.menu;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuMgmtDto {
    private Integer menuNo;
    private String menuName;
    private String menuKind;
    private String menuAuth;
    private String menuAuthNM;
    private Integer menuPageNo;
    private Integer menuPageGrpNo;
    private String guid;
    private String siteName;
    private Integer visibleOrder;
    private Integer isWebuse;
    private String webIconClass;
    private String originMenuName;
    private String menuType;
}
