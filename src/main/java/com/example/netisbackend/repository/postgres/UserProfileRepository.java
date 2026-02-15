package com.example.netisbackend.repository.postgres;

import com.example.netisbackend.entity.postgres.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
}
