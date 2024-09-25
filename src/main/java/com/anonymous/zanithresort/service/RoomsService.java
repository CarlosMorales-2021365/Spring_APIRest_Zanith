package com.anonymous.zanithresort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anonymous.zanithresort.model.Rooms;
import com.anonymous.zanithresort.repository.RoomsRepository;

@Service

public class RoomsService implements IRoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public List<Rooms> listRooms() {
        return roomsRepository.findAll();
    }

    @Override
    public Rooms findRooms(Integer idRoom) {
        Rooms rooms = roomsRepository.findById(idRoom).orElse(null);
        return rooms;
    }

    @Override
    public Rooms saveRooms(Rooms rooms) {
       return roomsRepository.save(rooms);
    }

    @Override
    public Integer getNextId() {
        List<Rooms> rooms = listRooms();
        if (rooms.isEmpty()) {
            return 1; // O cualquier otro valor inicial que desees
        }
        return rooms.stream()
                    .mapToInt(Rooms::getIdRoom)
                    .max()
                    .orElse(0) + 1; // Incrementar el ID más alto

    }

    



    



   





}
