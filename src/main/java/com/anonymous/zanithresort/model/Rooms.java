package com.anonymous.zanithresort.model;
import java.util.List;

import java.io.Serializable;

import com.anonymous.zanithresort.DTOs.AddRoomDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name="rooms")
public class Rooms implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer  idRoom;
    private String roomType;
    private double cost;
    private String capacity;
    private String availability;
    private String description;
    private String starDate;
    private String endDate;
    private String photo;


    public Rooms(AddRoomDTO addRoomDTO, String img, Hotels hotel){
        this.roomType = addRoomDTO.getRoomType();
        this.cost = addRoomDTO.getCost();
        this.capacity = addRoomDTO.getCapacity();
        this.availability = addRoomDTO.getAvailability();
        this.description = addRoomDTO.getDescription();
        this.starDate = addRoomDTO.getStarDate();
        this.endDate = addRoomDTO.getEndDate();
        this.photo = img;
        this.hotel= hotel;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotels hotel;

    @ManyToOne
    @JoinColumn(name = "ids")
    private Service service;
}
