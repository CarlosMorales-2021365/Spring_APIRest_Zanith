package com.anonymous.zanithresort.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {

    private Long id;

    @NotBlank(message = "El nombre del servicio es obligatorio")
    private String name;

    @NotNull(message = "El costo del servicio es obligatorio")
    private double cost;

    private String description;
}