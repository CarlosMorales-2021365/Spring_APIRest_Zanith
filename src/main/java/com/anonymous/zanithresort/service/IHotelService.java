package com.anonymous.zanithresort.service;
import java.util.List;

import com.anonymous.zanithresort.model.Hotels;
public interface IHotelService {

    public List <Hotels> listHotels();

    public Hotels findHotel (Integer hotel_id);

    public Hotels saveHotel (Hotels hotels);

    public void deleteHotel(Hotels hotels);
}
