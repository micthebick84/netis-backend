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
public class ComImgDto {
    private long imgNo;
    private String imgName;
    private String imgUid;
    private byte[] img;
    private String imgKind1;
    private String imgKind2;
    private String imgKind3;
    private int sConf;
    private int sortIdx;
    private int isDisplay;
}
