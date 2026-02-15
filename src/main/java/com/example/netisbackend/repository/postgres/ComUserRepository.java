package com.example.netisbackend.repository.postgres;

import com.example.netisbackend.entity.postgres.ComUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComUserRepository extends JpaRepository<ComUser, String> {

    List<ComUser> findByUseFlag(Short useFlag);
}
