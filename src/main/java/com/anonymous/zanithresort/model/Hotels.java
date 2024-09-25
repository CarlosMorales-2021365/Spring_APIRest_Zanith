package com.anonymous.zanithresort.model;
import java.io.Serializable;
import java.util.List;

import com.anonymous.zanithresort.DTOs.HotelRegisterDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Hotels")
public class Hotels implements Serializable {
    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  hotel_id;
    private String name;
    private String direction;
    private int category;
    private String description;
    private double average_price;
    private String photo;
 
    public Hotels(HotelRegisterDTO hotelRegisterDto, String img) {
        this.hotel_id =hotelRegisterDto.getHotel_id();
        this.name = hotelRegisterDto.getName();
        this.direction =hotelRegisterDto.getDirection();
        this.category = hotelRegisterDto.getCategory();
        this.description =hotelRegisterDto.getDescription();
        this.average_price =hotelRegisterDto.getAverage_price();
        this.photo = img;
    }


   //@OneToMany
   // private List<Rooms> rooms;

   // @OneToOne
   //private Event event;
}