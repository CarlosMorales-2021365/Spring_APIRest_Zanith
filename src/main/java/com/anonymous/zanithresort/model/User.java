package com.anonymous.zanithresort.model;

import java.io.Serializable;

import com.anonymous.zanithresort.DTOs.UserRegisterDTO;
import com.anonymous.zanithresort.utils.PasswordEncrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Email(message = "Ingresa Direccion de correo Valida")
    @Column(unique = true, name="email")
    private String email;

    @Column(unique = true)
    private String username;

    private String name;
    private String surname;
    private String password;
    private String phone;
    private String role;
    private String urlProfilePhoto;

  

    public User(UserRegisterDTO userDTO, String img) {
        this.email = userDTO.getEmail();
        this.username = userDTO.getUsername();
        this.password = PasswordEncrypt.encryptPassword(userDTO.getPassword());
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.role = userDTO.getRole();
        this.phone = userDTO.getPhone();
        this.urlProfilePhoto = img;
    }


}
