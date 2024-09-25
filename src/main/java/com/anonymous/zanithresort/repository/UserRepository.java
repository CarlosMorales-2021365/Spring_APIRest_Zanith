package com.anonymous.zanithresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anonymous.zanithresort.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
