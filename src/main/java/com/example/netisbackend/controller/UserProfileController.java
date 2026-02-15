package com.example.netisbackend.controller;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.user.UserProfileResponse;
import com.example.netisbackend.dto.user.UserProfileUpdateRequest;
import com.example.netisbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ApiResponse<UserProfileResponse> getUserProfile(@PathVariable String userId) {
        UserProfileResponse profile = userService.getUserProfile(userId);
        return ApiResponse.success(profile);
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserProfileResponse> updateUserProfile(
            @PathVariable String userId,
            @RequestBody UserProfileUpdateRequest request) {
        UserProfileResponse profile = userService.updateUserProfile(userId, request);
        return ApiResponse.success("Profile updated", profile);
    }
}
