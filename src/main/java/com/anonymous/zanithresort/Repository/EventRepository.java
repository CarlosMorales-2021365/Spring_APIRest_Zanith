package com.anonymous.zanithresort.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anonymous.zanithresort.model.Event;

public interface EventRepository extends JpaRepository <Event, Integer> {
    
}


