package com.example.netisbackend.dto.menu;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LayoutMenuDto {
    private String menuName;
    private String guid;
    private String grpType;
    private String scondUse;
    private Integer isRegMenu;
}
