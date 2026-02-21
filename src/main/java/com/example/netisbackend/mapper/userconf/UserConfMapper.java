package com.example.netisbackend.mapper.userconf;

import com.example.netisbackend.dto.userconf.UserConfDto;
import com.example.netisbackend.dto.userconf.UserConfSaveDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserConfMapper {

    List<UserConfDto> selectUserList();

    UserConfDto selectUserById(@Param("userId") String userId);

    void insertUser(UserConfSaveDto dto);

    void updateUser(UserConfSaveDto dto);

    void deleteUser(@Param("userId") String userId);

    void updatePassword(
        @Param("userId") String userId,
        @Param("hashedPassword") String hashedPassword,
        @Param("salt") String salt
    );
}
