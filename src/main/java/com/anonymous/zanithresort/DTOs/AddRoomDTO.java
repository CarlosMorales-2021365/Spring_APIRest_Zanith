package com.anonymous.zanithresort.DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddRoomDTO implements Serializable {
    private String id;
    private String roomType;
    private double cost;
    private String capacity;
    private String availability;
    private String description;
    private String starDate;
    private String endDate;
    private Long hotel_id;
    private Long ids;

}
