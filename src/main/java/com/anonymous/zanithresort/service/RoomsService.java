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
    public Rooms findRooms(Long idRoom) {
        Rooms rooms = roomsRepository.findById(idRoom).orElse(null);
        return rooms;
    }

    @Override
    public Rooms saveRooms(Rooms rooms) {
       return roomsRepository.save(rooms);
    }

    



    



   





}
