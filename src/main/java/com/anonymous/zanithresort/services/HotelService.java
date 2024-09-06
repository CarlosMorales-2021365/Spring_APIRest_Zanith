package com.anonymous.zanithresort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anonymous.zanithresort.Repository.HotelRepository;
import com.anonymous.zanithresort.models.Hotels;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotels> listHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotels findHotel(Integer hotel_id) {
        Hotels hotels = hotelRepository.findById(hotel_id).orElse(null);
        return hotels;
    }

    @Override
    public Hotels saveHotel(Hotels hotels) {
        return hotelRepository.save(hotels);
    }

    @Override
    public void deleteHotel(Hotels hotels) {
       hotelRepository.delete(hotels);
    }

}
