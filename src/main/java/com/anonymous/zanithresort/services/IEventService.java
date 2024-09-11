package com.anonymous.zanithresort.services;

import java.util.List;

import com.anonymous.zanithresort.model.Event;

public interface IEventService {
    public List <Event> listEvent();

    public Event findEvent (Integer id_Event);

    public Event saveEvent (Event events);

    public void deleteEvent(Event events);

}
