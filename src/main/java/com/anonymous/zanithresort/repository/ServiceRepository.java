package com.anonymous.zanithresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anonymous.zanithresort.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}