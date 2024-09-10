package com.anonymous.zanithresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anonymous.zanithresort.models.User;

public interface AuthRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
