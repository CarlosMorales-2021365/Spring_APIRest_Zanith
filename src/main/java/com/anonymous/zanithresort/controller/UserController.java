package com.anonymous.zanithresort.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anonymous.zanithresort.DTOs.UserRegisterDTO;
import com.anonymous.zanithresort.model.User;
import com.anonymous.zanithresort.service.CloudinaryService;
import com.anonymous.zanithresort.service.UserService;
import com.anonymous.zanithresort.utils.PasswordEncrypt;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Zanith/v1/User")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/ListaUsuarios") 
    public ResponseEntity<?> ListaUsuarios(
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @Valid @ModelAttribute UserRegisterDTO userDto,
            BindingResult result) {

        Map<String, Object> res = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            res.put("Errores", errors);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        try {
            logger.info("Enviando Archivado a Cloudinary");
            Map<String, Object> uploadResult = cloudinaryService.uploadImg(profilePicture, "profiles");
            String profilePhoto = uploadResult.get("url").toString();
            String img = profilePhoto.substring(profilePhoto.indexOf("profiles/"));
            User user = new User(userDto, img);
            user.setId(UUID.randomUUID().toString());
            userService.save(user);
            logger.info("Usuario agregado exitosamente");
            res.put("Mensaje", "Usuario agregado exitosamente");
            res.put("Usuario", user);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (IOException e) {
            logger.error("Error de entrada de archivos", e);
            res.put("Mensaje", "Error al subir la imagen");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (CannotCreateTransactionException e) {
            logger.error("Error al procesar la transacción", e);
            res.put("Mensaje", "Error al crear la transacción");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
        } catch (DataAccessException e) {
            logger.error("Error al conectar a la base de datos", e);
            res.put("Mensaje", "Error conectar a la base de datos");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody User user, BindingResult result) {
        Map<String, Object> res = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
            res.put("Errores", errors);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        try {
            User existingUser = userService.login(user.getEmail());
            if (existingUser == null || !PasswordEncrypt.verifyPassword(user.getPassword(), existingUser.getPassword())) {
                res.put("Mensaje", "Usuario o contraseña incorrectas");
                return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
            }

            res.put("Mensaje", "Bienvenido " + existingUser.getUsername());
            res.put("Usuario", existingUser);
            return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
        } catch (CannotCreateTransactionException e) {
            logger.error("Error al procesar tu transacción", e);
            res.put("Mensaje", "Error al crear la transacción");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
        } catch (DataAccessException e) {
            logger.error("Error al conectar a la base de datos", e);
            res.put("Mensaje", "Error conectar a la base de datos");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    
}
