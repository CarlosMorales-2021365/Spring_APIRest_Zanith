package com.anonymous.zanithresort.service;

import java.util.List;

import com.anonymous.zanithresort.model.Rooms;

public interface IRoomsService {

    public List<Rooms> listRooms();

    public Rooms findRooms(Long idRoom);

    public Rooms saveRooms(Rooms rooms);
}
