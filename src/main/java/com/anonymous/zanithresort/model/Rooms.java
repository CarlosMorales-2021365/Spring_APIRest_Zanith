package com.anonymous.zanithresort.model;

import java.io.Serializable;
<<<<<<< HEAD
import java.sql.Date;
=======

import com.anonymous.zanithresort.DTOs.AddRoomDTO;
>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.Table;
import lombok.Data;

=======
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
@Entity
@Data
@Table(name="rooms")
public class Rooms implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
<<<<<<< HEAD
    private long idRoom;
=======
    private String idRoom;
>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
    private String roomType;
    private double cost;
    private String capacity;
    private String availability;
    private String description;
<<<<<<< HEAD
    private Date starDate;
    private Date endDate;


    // @OneToMany
    // Private Hotel hotel;
    
=======
    private String starDate;
    private String endDate;
    private String photo;

    public Rooms(AddRoomDTO addRoomDTO, String img){
        this.roomType = addRoomDTO.getRoomType();
        this.cost = addRoomDTO.getCost();
        this.capacity = addRoomDTO.getCapacity();
        this.availability = addRoomDTO.getAvailability();
        this.description = addRoomDTO.getDescription();
        this.starDate = addRoomDTO.getStarDate();
        this.endDate = addRoomDTO.getEndDate();
        this.photo = img;
    }

    @ManyToOne //(mappedBy = "idRoom")
    private Hotels hotels;

>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
}
