package com.anonymous.zanithresort.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="rooms")
public class Rooms implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idRoom;
    private String roomType;
    private double cost;
    private String capacity;
    private String availability;
    private String description;
    private Date starDate;
    private Date endDate;
    private String photo;


     // @ManyToOne 
    // private Hotels hotels;
    
}
