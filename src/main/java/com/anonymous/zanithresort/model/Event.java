package com.anonymous.zanithresort.model;

import java.io.Serializable;
import java.sql.Date;

import com.anonymous.zanithresort.utils.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Events")
public class Event implements Serializable {
    @Id
    @Column(name="id_Event")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_Event;
    private String name_Event;
    private Date startTime_Event;
    private Date endTime_Event;
    private String description_Event;
    private String State_Event;
    private int capacity_Event;
    private Status status;

    //@ManyToOne
    //private Hotel hotel;
    

}