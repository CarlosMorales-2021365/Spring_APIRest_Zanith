package com.anonymous.zanithresort.services;
import java.util.List;

import com.anonymous.zanithresort.models.Hotels;
public interface IHotelService {

    public List <Hotels> listHotels();

    public Hotels findHotel (Integer hotel_id);

    public Hotels saveHotel (Hotels hotels);

    public void deleteHotel(Hotels hotels);
}
