package com.example.netisbackend.dto.menu;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private Integer pageNo;
    private Integer pageGrpNo;
    private Integer menuNo;
    private String menuName;
    private String guid;
    private String menuAuth;
    private Integer orderNo;
    private String menuType;
    private String linkViewType;
    private String grpType;
    private String scondUse;
    private String rtUse;
    private String urlPath;
}
