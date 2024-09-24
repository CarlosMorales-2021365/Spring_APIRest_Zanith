package com.anonymous.zanithresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anonymous.zanithresort.model.Event;

public interface EventRepository extends JpaRepository <Event, Integer> {
    
}


