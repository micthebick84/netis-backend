package com.example.netisbackend.service;

import com.example.netisbackend.dto.userconf.UserConfDto;
import com.example.netisbackend.dto.userconf.UserConfSaveDto;
import com.example.netisbackend.mapper.userconf.UserConfMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserConfService {

    private final UserConfMapper userConfMapper;

    public List<UserConfDto> getUsers() {
        return userConfMapper.selectUserList();
    }

    @Transactional
    public void saveUser(List<UserConfSaveDto> dtoList) {
        for (UserConfSaveDto dto : dtoList) {
            userConfMapper.updateUser(dto);
        }
    }

    @Transactional
    public void addUser(UserConfSaveDto dto) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(dto.getPassword(), salt);
        dto.setPassword(hashedPassword);
        dto.setPwSalt(salt);
        userConfMapper.insertUser(dto);
    }

    @Transactional
    public void deleteUser(String userId) {
        userConfMapper.deleteUser(userId);
    }

    @Transactional
    public void changePassword(String userId, String newPassword) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(newPassword, salt);
        userConfMapper.updatePassword(userId, hashedPassword, salt);
    }

    private String generateSalt() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
