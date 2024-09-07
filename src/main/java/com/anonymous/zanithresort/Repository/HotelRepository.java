package com.anonymous.zanithresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anonymous.zanithresort.model.Hotels;

public interface HotelRepository  extends JpaRepository<Hotels, Integer> {

}
