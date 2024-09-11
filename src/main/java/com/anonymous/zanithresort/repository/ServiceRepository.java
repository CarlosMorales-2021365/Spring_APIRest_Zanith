package com.anonymous.zanithresort.repository;

import com.anonymous.zanithresort.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}