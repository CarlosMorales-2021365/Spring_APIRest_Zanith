package com.anonymous.zanithresort.service;

import java.util.List;

import com.anonymous.zanithresort.model.Event;

public interface IEventService {
    
    public List <Event> listEvent();

    public Event findEvent (Integer id_Event);

    public Event addEvent (Event events);

    public void deleteEvent(Event events);

}
