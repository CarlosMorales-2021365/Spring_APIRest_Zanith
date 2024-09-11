package com.anonymous.zanithresort.models;

import java.io.Serializable;

import com.anonymous.zanithresort.DTOs.UserRegisterDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Email(message = "Ingresa Direccion de correo Valida")
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String name;
    @Column(unique = true)
    private String surname;

    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private String phone;

    private String role;
    private String urlProfilePhoto;

 

    public User(UserRegisterDTO userDTO, String img) {
        this.email = userDTO.getEmail();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.role = userDTO.getRole();
        this.phone = userDTO.getPhone();
        this.urlProfilePhoto = img;
    }


}
