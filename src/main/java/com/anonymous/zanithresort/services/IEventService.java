package com.anonymous.zanithresort.services;

import java.util.List;

import com.anonymous.zanithresort.model.Event;

public interface IEventService {
    public List <Events> listEvent();

    public Events findEvent (Integer id_Event);

    public Events saveEvent (Event events);

    public void deleteEvent(Event events);

}
