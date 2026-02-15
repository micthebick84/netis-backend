package com.example.netisbackend.controller;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.user.ComUserResponse;
import com.example.netisbackend.dto.user.UserInfoResponse;
import com.example.netisbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ApiResponse<UserInfoResponse> getCurrentUser(@AuthenticationPrincipal Jwt jwt) {
        String username = jwt.getClaim("username");
        UserInfoResponse user = userService.getUserByUsername(username);
        return ApiResponse.success(user);
    }

    @GetMapping("/com/{userId}")
    public ApiResponse<ComUserResponse> getComUser(@PathVariable String userId) {
        ComUserResponse comUser = userService.getComUser(userId);
        return ApiResponse.success(comUser);
    }

    @GetMapping("/com")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<ComUserResponse>> getActiveComUsers() {
        List<ComUserResponse> users = userService.getActiveComUsers();
        return ApiResponse.success(users);
    }
}
