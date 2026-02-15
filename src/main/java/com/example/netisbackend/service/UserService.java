package com.example.netisbackend.service;

import com.example.netisbackend.dto.user.ComUserResponse;
import com.example.netisbackend.dto.user.UserInfoResponse;
import com.example.netisbackend.dto.user.UserProfileResponse;
import com.example.netisbackend.dto.user.UserProfileUpdateRequest;
import com.example.netisbackend.entity.postgres.ComUser;
import com.example.netisbackend.entity.postgres.User;
import com.example.netisbackend.entity.postgres.UserProfile;
import com.example.netisbackend.repository.postgres.ComUserRepository;
import com.example.netisbackend.repository.postgres.UserProfileRepository;
import com.example.netisbackend.repository.postgres.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ComUserRepository comUserRepository;
    private final UserProfileRepository userProfileRepository;

    public UserInfoResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
        return toUserInfoResponse(user);
    }

    public ComUserResponse getComUser(String userId) {
        ComUser comUser = comUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("ComUser not found: " + userId));
        return toComUserResponse(comUser);
    }

    public List<ComUserResponse> getActiveComUsers() {
        return comUserRepository.findByUseFlag((short) 1).stream()
                .map(this::toComUserResponse)
                .collect(Collectors.toList());
    }

    public UserProfileResponse getUserProfile(String userId) {
        UserProfile profile = userProfileRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("UserProfile not found: " + userId));
        return toUserProfileResponse(profile);
    }

    @Transactional
    public UserProfileResponse updateUserProfile(String userId, UserProfileUpdateRequest request) {
        UserProfile profile = userProfileRepository.findById(userId)
                .orElseGet(() -> {
                    UserProfile newProfile = new UserProfile();
                    newProfile.setUserId(userId);
                    return newProfile;
                });

        if (request.getAvatarUrl() != null) {
            profile.setAvatarUrl(request.getAvatarUrl());
        }
        if (request.getBio() != null) {
            profile.setBio(request.getBio());
        }

        UserProfile saved = userProfileRepository.save(profile);
        return toUserProfileResponse(saved);
    }

    private UserInfoResponse toUserInfoResponse(User user) {
        return UserInfoResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .enabled(user.isEnabled())
                .authorities(user.getAuthorities().stream()
                        .map(a -> a.getAuthority())
                        .collect(Collectors.toSet()))
                .createdAt(user.getCreatedAt())
                .build();
    }

    private ComUserResponse toComUserResponse(ComUser comUser) {
        return ComUserResponse.builder()
                .userId(comUser.getUserId())
                .userName(comUser.getUserName())
                .deptName(comUser.getDeptName())
                .posName(comUser.getPosName())
                .email(comUser.getEmail())
                .officeTel(comUser.getOfficeTel())
                .cellTel(comUser.getCellTel())
                .auth(comUser.getAuth())
                .useFlag(comUser.getUseFlag())
                .dashboardAuth(comUser.getDashboardAuth())
                .menuAuthNo(comUser.getMenuAuthNo())
                .build();
    }

    private UserProfileResponse toUserProfileResponse(UserProfile profile) {
        return UserProfileResponse.builder()
                .userId(profile.getUserId())
                .avatarUrl(profile.getAvatarUrl())
                .bio(profile.getBio())
                .updatedAt(profile.getUpdatedAt())
                .build();
    }
}
