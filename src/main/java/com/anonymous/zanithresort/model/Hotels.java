package com.anonymous.zanithresort.model;

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
public class Hotels {
    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotel_id;
    private String name;
    private String direction;
    private int category;
    private String description;
    private double average_price;
<<<<<<< HEAD

=======
 
>>>>>>> origin/developer
}