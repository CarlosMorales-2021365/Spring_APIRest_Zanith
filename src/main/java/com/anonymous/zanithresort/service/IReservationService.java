package com.anonymous.zanithresort.service;

import java.util.List;
import com.anonymous.zanithresort.model.Reservation;

public interface IReservationService {

    public List<Reservation> listReservation();

    public Reservation findReservation(Integer id);

    public Reservation saveReservation(Reservation reservation);

    public void deleteReservation(Reservation reservation);
}
