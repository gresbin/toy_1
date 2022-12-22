package com.example.toy1.repository;

import com.example.toy1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userid);
    Optional<User> findByNickname(String nickname);
}
