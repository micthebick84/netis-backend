package com.example.netisbackend.dto.menu;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {
    private Integer pageNo;
    private String pageName;
    private Integer orderNo;
    private String webIconClass;
    private List<PageGrpDto> children;
}
