package com.example.netisbackend.controller;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.userconf.PasswordChangeDto;
import com.example.netisbackend.dto.userconf.UserConfDto;
import com.example.netisbackend.dto.userconf.UserConfSaveDto;
import com.example.netisbackend.service.UserConfService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userconf")
@RequiredArgsConstructor
public class UserConfController {

    private final UserConfService userConfService;

    @GetMapping("/list")
    public ApiResponse<List<UserConfDto>> getUsers() {
        List<UserConfDto> users = userConfService.getUsers();
        return ApiResponse.success(users);
    }

    @PostMapping("/save")
    public ApiResponse<Void> saveUser(@RequestBody List<UserConfSaveDto> dtoList) {
        userConfService.saveUser(dtoList);
        return ApiResponse.success("저장되었습니다.", null);
    }

    @PostMapping("/add")
    public ApiResponse<Void> addUser(@RequestBody UserConfSaveDto dto) {
        userConfService.addUser(dto);
        return ApiResponse.success("등록되었습니다.", null);
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteUser(@RequestParam String userId) {
        userConfService.deleteUser(userId);
        return ApiResponse.success("삭제되었습니다.", null);
    }

    @PostMapping("/change-password")
    public ApiResponse<Void> changePassword(@RequestBody PasswordChangeDto dto) {
        userConfService.changePassword(dto.getUserId(), dto.getNewPassword());
        return ApiResponse.success("비밀번호가 변경되었습니다.", null);
    }
}
