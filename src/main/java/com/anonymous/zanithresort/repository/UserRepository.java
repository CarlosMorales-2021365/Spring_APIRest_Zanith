package com.anonymous.zanithresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anonymous.zanithresort.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

}
