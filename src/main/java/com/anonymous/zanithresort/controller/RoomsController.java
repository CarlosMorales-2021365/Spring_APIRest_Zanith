package com.anonymous.zanithresort.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anonymous.zanithresort.exception.RoomsException;
import com.anonymous.zanithresort.model.Rooms;
import com.anonymous.zanithresort.service.IRoomsService;

@RestController
@RequestMapping("Zanith/v1/rooms")
public class RoomsController {
    private final Logger logger = LoggerFactory.getLogger(RoomsController.class);

@Autowired
private IRoomsService iRoomsService;

@GetMapping("/rooms")

public List<Rooms> getRoom(){
    var room2 = iRoomsService.listRooms();
    room2.forEach((room -> logger.info(room.toString())));
    return room2;
}

@PostMapping("/addRoom")
public Rooms addRoom(@RequestBody Rooms rooms){
    logger.info("Habitacion agregada"+rooms);
    return iRoomsService.saveRooms(rooms);

}

@GetMapping("/buscar/{idRoom}")
 public ResponseEntity<Rooms> findRooms(@PathVariable Long idRoom){
    Rooms rooms = iRoomsService.findRooms(idRoom);
    if(rooms==null)
    throw new RoomsException("No se encontro la habitacion");
    return ResponseEntity.ok(rooms);
 } 


@PatchMapping("/editrooms/{idRoom}")
public ResponseEntity <Rooms> editRoom(@PathVariable Long idRoom,@RequestBody Rooms roomReceived){
    Rooms rooms = iRoomsService.findRooms(idRoom);
    if(rooms == null)
    throw new RoomsException("El id recibido no exixte");
    rooms.setIdRoom(roomReceived.getIdRoom());
    rooms.setRoomType(roomReceived.getRoomType());
    rooms.setCost(roomReceived.getCost());
    rooms.setCapacity(roomReceived.getCapacity());
    rooms.setAvailability(roomReceived.getAvailability());
    rooms.setDescription(roomReceived.getDescription());
    rooms.setStarDate(roomReceived.getStarDate());
    rooms.setEndDate(roomReceived.getEndDate());
    iRoomsService.saveRooms(rooms);
    return ResponseEntity.ok(rooms);
}


}
