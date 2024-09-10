package com.anonymous.zanithresort.services;

import java.util.List;
import com.anonymous.zanithresort.models.Event;

public interface IEvent {
    public List <Event> listHotels();

    public Event findEvent (Integer id_Event);

    public Event saveEvent (Event events);

    public void deleteEvent(Event events);

}
