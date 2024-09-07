package com.anonymous.zanithresort.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


=======
import jakarta.persistence.Table;
import lombok.Data;

>>>>>>> origin/developer
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


<<<<<<< HEAD
    @ManyToOne //(mappedBy = "idRoom")
    private Hotels hotels;

=======
    // @OneToMany
    // Private Hotel hotel;
    
>>>>>>> origin/developer
}
