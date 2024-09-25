package com.anonymous.zanithresort.DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class HotelRegisterDTO implements Serializable {

    private Integer  hotel_id;
    private String name;
    private String direction;
    private int category;
    private String description;
    private double average_price;
}
