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
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.anonymous.zanithresort.exception.HotelsException;
import com.anonymous.zanithresort.model.Hotels;
import com.anonymous.zanithresort.service.IHotelService;

@RestController // http://localhost:8081/Hotels
=======

import com.anonymous.zanithresort.Exception.HotelsException;
import com.anonymous.zanithresort.service.IHotelService;
import com.anonymous.zanithresort.model.Hotels;

@RestController // http://localhost:8085/hotels
>>>>>>> origin/developer

@RequestMapping("/Hotels/v1")
public class HotelsController {

    private static final Logger logger = LoggerFactory.getLogger(HotelsController.class);

    @Autowired
    private IHotelService iHotelService;

    @GetMapping("/ListHotels")

    public List<Hotels> listHotels() {
        var hotel2 = iHotelService.listHotels();
        hotel2.forEach(hotels -> logger.info(hotels.toString()));
        return hotel2;

    }

    @PostMapping("/AddHotel")
    public Hotels saveHotel(@RequestBody Hotels hotels) {
        logger.info("Hotel agregado");
        return iHotelService.saveHotel(hotels);

    }

    @GetMapping("/FindHotel/{hotel_id}")
    public ResponseEntity<Hotels> findHotel(@PathVariable Integer hotel_id) {
        Hotels hotels = iHotelService.findHotel(hotel_id);
        if (hotel_id == null)
            throw new HotelsException("No se encuentra empleado");
        return ResponseEntity.ok(hotels);
    }

    @DeleteMapping("/DeleteHotel/{hotel_id}")
    public ResponseEntity<Map<String, Boolean>> deleteHotel(@PathVariable Integer hotel_id) {
        Hotels hotel = iHotelService.findHotel(hotel_id);
        if (hotel == null)
            throw new HotelsException("el empleado no existe");
        iHotelService.deleteHotel(hotel);

        // JSON {eliminad: true}

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", true);
        return ResponseEntity.ok(respuesta);

    }

    @PutMapping("/UpdateHotel/{hotel_id}")
        public ResponseEntity <Hotels> editarEmpleados (@PathVariable Integer hotel_id, @RequestBody Hotels hotelsCheck){
            Hotels hotels = iHotelService.findHotel(hotel_id);
            if (hotels == null)
                throw new HotelsException("El id recibido no existe");{
               
                hotels.setName(hotelsCheck.getName());
                hotels.setDirection(hotelsCheck.getDirection());
                hotels.setCategory(hotelsCheck.getCategory());
                hotels.setDescription(hotelsCheck.getDescription());
                hotels.setAverage_price(hotelsCheck.getAverage_price());
                iHotelService.saveHotel(hotels);
                return ResponseEntity.ok(hotels);
       
                }
            }
}
