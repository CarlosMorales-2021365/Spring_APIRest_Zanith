package com.anonymous.zanithresort.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anonymous.zanithresort.exception.ReservationException;
import com.anonymous.zanithresort.model.Reservation;
import com.anonymous.zanithresort.model.Rooms;
import com.anonymous.zanithresort.model.User;
import com.anonymous.zanithresort.service.HotelService;
import com.anonymous.zanithresort.service.IReservationService;
import com.anonymous.zanithresort.service.RoomsService;
import com.anonymous.zanithresort.service.UserService;

@RestController // http://localhost:8086/Zanith

@RequestMapping("Zanith/v1/reservation")
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private IReservationService iReservationService;

    @Autowired
    private RoomsService roomsService;

    @Autowired
    private UserService userService;

    @GetMapping("/ListReservation")
    public List<Reservation> listReservation() {
        List<Reservation> reservations = iReservationService.listReservation();
        reservations.forEach(reservation -> logger.info(reservation.toString()));
        return reservations;
    }

    @PostMapping("/AddReservation")
    public ResponseEntity<?> saveReservation(@RequestBody Reservation reservation, @RequestParam("rooms_id") Integer roomsId, @RequestParam("user_id") Integer userId) {

        Rooms room = roomsService.findRooms(roomsId); 
        User user = userService.find(userId); 

        if (room == null) {
            return ResponseEntity.badRequest().body("Habitación no encontrada");
        }
    
        if (user == null) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        reservation.setRooms(room); 
        reservation.setUser(user);   

        logger.info("Reservación agregada: " + reservation);
        Reservation savedReservation = iReservationService.saveReservation(reservation);
        return ResponseEntity.ok(savedReservation);
    }

    @GetMapping("/FindReservation/{id}")
    public ResponseEntity<Reservation> findReservation(@PathVariable Integer id) {
        Reservation reservation = iReservationService.findReservation(id);
        if (reservation == null) {
            throw new ReservationException("No se ha encontrado la reservación con el ID proporcionado");
        }
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/DeleteReservation/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReservation(@PathVariable Integer id) {
        Reservation reservation = iReservationService.findReservation(id);
        if (reservation == null) {
            throw new ReservationException("La Reservación no existe");
        }
        iReservationService.deleteReservation(reservation);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", true);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/UpdateReservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Integer id, @RequestBody Reservation reservationUpdate) {
        Reservation reservation = iReservationService.findReservation(id);
        if (reservation == null) {
            throw new ReservationException("No existe el ID de la reservación");
        }

        reservation.setState(reservationUpdate.getState());
        reservation.setDateCheckIn(reservationUpdate.getDateCheckIn());
        reservation.setDateCheckOut(reservationUpdate.getDateCheckOut());
        reservation.setTotalPrice(reservationUpdate.getTotalPrice());

        iReservationService.saveReservation(reservation);
        return ResponseEntity.ok(reservation);
    }
}