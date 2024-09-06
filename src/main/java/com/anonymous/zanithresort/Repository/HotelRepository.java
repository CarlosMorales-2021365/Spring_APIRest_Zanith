package com.anonymous.zanithresort.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anonymous.zanithresort.models.Hotels;

public interface HotelRepository  extends JpaRepository<Hotels, Integer> {

}
