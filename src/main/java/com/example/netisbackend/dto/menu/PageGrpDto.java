package com.example.netisbackend.dto.menu;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageGrpDto {
    private Integer pageNo;
    private Integer pageGrpNo;
    private String pageGrpName;
    private Integer orderNo;
    private List<MenuDto> children;
}
