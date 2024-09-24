package com.anonymous.zanithresort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anonymous.zanithresort.model.Event;
import com.anonymous.zanithresort.repository.EventRepository;

@Service
public class EventService implements IEventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> listEvent() {
    return eventRepository.findAll();

    }

    @Override
    public Event findEvent(Integer id_Event) {
        Event events = eventRepository.findById(id_Event).orElse(null);
        return events;

    }

    @Override
    public Event addEvent(Event events) {
        return eventRepository.save(events);

    }

    @Override
    public void deleteEvent(Event events) {
        eventRepository.delete(events);
        
    }

}