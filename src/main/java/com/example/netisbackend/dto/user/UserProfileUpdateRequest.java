package com.example.netisbackend.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileUpdateRequest {

    private String avatarUrl;
    private String bio;
}
