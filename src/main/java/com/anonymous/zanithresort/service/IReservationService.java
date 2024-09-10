package com.anonymous.zanithresort.service;
import java.util.List

public interface IReservationService {

    public List <Reservation> listReservation();

    public Reservation finReservation (Integer ID_Reservation);

    public Reservation saveReservation (Reservation reservation);

    public void deleteReservation (Reservation reservation);
}
