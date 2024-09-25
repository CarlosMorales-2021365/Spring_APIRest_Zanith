package com.anonymous.zanithresort.DTOs;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterDTO implements Serializable {
    private Integer id;
    @NotBlank(message = "Correo Obligatorio")
    @Email(message = "Ingresa direccion de correo valida")
    private String email;
    @NotBlank(message = "Contraseña Obligatoria")
    private String password;
    @NotBlank(message = "Usuario Obligatorio")
    private String username;
    private String name;
    private String surname;
    @NotBlank(message = "Telefono Obligatorio")
    private String phone;
    private String role;
}
