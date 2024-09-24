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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anonymous.zanithresort.DTOs.AddRoomDTO;
import com.anonymous.zanithresort.exception.RoomsException;
import com.anonymous.zanithresort.model.Rooms;
import com.anonymous.zanithresort.service.CloudinaryService;
import com.anonymous.zanithresort.service.RoomsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Zanith/v1/rooms")
public class RoomsController {
    private final Logger logger = LoggerFactory.getLogger(RoomsController.class);

@Autowired
RoomsService RoomsService;

@Autowired
CloudinaryService cloudinaryService;

@GetMapping("/rooms")

public List<Rooms> getRoom(){
    var room2 = RoomsService.listRooms();
    room2.forEach((room -> logger.info(room.toString())));
    return room2;
}

@PostMapping("/addRoom")
public ResponseEntity<?> addRoom(
    @RequestPart("photo") MultipartFile picture,
    @Valid @ModelAttribute AddRoomDTO addRoomDTO,
    BindingResult result){
    
    Map<String, Object> res = new HashMap<>();

    if(result.hasErrors()){
       List<String> errors = result.getFieldErrors()
            .stream()
            .map(error -> error.getDefaultMessage())
            .collect(Collectors.toList());
       res.put("Errores", errors);
       return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); 
    }
    try {
        logger.info("Enviando el archivo a cloudinary");
        Map<String,Object> uploadResult = cloudinaryService.uploadImg(picture, "profiles");
        String photo = uploadResult.get("url").toString();
        String img = photo.substring(photo.indexOf("profiles/"));
        Rooms rooms = new Rooms(addRoomDTO,img);
        rooms.setIdRoom(UUID.randomUUID().toString());
        RoomsService.saveRooms(rooms);
        logger.info("La habitacion fue agregada exitosamente");
        res.put("Mensaje", "La habitacion fue agregada exitosamente");
        res.put("Habitacion", rooms);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    } catch (IOException e) {
        logger.error("Error de entrada de archivos");
        res.put("Mensaje", "Error al subir la imagen");
        res.put("Error", e.getMessage());
        return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
    }catch(CannotCreateTransactionException e){
        logger.error("Error al procesar la transacccion");
        res.put("Mensaje", "Error al crea la transaccion");
        res.put("Error",e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
    }catch(DataAccessException e){
        logger.error("Error al conectar con la base de datos");
        res.put("Mensaje", "Error al conectar con la base de datos");
        res.put("Error", e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
    }
}





@GetMapping("/buscar/{idRoom}")
 public ResponseEntity<Rooms> findRooms(@PathVariable Long idRoom){
    Rooms rooms = RoomsService.findRooms(idRoom);
    if(rooms==null)
    throw new RoomsException("No se encontro la habitacion");
    return ResponseEntity.ok(rooms);
 } 


@PutMapping("/editrooms/{idRoom}")
public ResponseEntity <Rooms> editRoom(@PathVariable Long idRoom,@RequestBody Rooms roomReceived){
    Rooms rooms = RoomsService.findRooms(idRoom);
    if(rooms == null)
    throw new RoomsException("El id recibido no exixte");
    rooms.setAvailability(roomReceived.getAvailability());
    rooms.setStarDate(roomReceived.getStarDate());
    rooms.setEndDate(roomReceived.getEndDate());
    RoomsService.saveRooms(rooms);
    return ResponseEntity.ok(rooms);
}


}
