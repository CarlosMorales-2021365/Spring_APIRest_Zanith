package com.anonymous.zanithresort.model;

<<<<<<< HEAD
import java.io.Serializable;

import com.anonymous.zanithresort.DTOs.HotelRegisterDTO;

=======
>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Hotels")
<<<<<<< HEAD
public class Hotels implements Serializable {
    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String hotel_id;
=======
public class Hotels {
    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotel_id;
>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
    private String name;
    private String direction;
    private int category;
    private String description;
    private double average_price;
    private String photo;
 
<<<<<<< HEAD
    public Hotels(HotelRegisterDTO hotelRegisterDto, String img) {
        this.hotel_id =hotelRegisterDto.getHotel_id();
        this.name = hotelRegisterDto.getName();
        this.direction =hotelRegisterDto.getDirection();
        this.category = hotelRegisterDto.getCategory();
        this.description =hotelRegisterDto.getDescription();
        this.average_price =hotelRegisterDto.getAverage_price();
        this.photo = img;
    }
=======

>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
}