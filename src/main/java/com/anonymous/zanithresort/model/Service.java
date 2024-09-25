package com.anonymous.zanithresort.model;

import com.anonymous.zanithresort.DTOs.ServiceDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ids;

    @NotBlank(message = "El nombre del servicio es obligatorio")
    private String name;

    @NotNull(message = "El costo del servicio es obligatorio")
    private double cost;

    private String description;

    public Service(ServiceDTO serviceDTO) {
        this.name = serviceDTO.getName();
        this.cost = serviceDTO.getCost();
        this.description = serviceDTO.getDescription();
    }
}