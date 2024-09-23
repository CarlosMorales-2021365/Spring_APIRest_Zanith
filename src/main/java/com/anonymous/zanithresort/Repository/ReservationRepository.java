package com.anonymous.zanithresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anonymous.zanithresort.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
}
