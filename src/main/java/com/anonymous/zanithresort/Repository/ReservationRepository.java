package com.anonymous.zanithresort.repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import com.anonymous.zanithresort.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
     @GetMapping("/ListReservation")
    public List<Reservation> listReservation() {
        List<Reservation> reservations = iReservationService.listReservation();
        reservations.forEach(reservation -> logger.info(reservation.toString()));
        return reservations;
    }
}
