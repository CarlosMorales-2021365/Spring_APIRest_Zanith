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

import com.anonymous.zanithresort.exception.EventException;
import com.anonymous.zanithresort.model.Event;
import com.anonymous.zanithresort.services.IEventService;

@RestController //http://localhost:8085/Zanith
@RequestMapping("/Events/v1")
public class EventController {
    
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private IEventService iEventService;

    @GetMapping("/ListEvents")
    public List<Event> listEvent() {
        var event2 = iEventService.listEvent();
        event2.forEach(events -> logger.info(events.toString()));
        return event2;

    }

    @GetMapping("/FindEvents/{id_Event}")
    public ResponseEntity<Event> findEvent(@PathVariable Integer id_Event) {
        Event events = iEventService.findEvent(id_Event);
        if (id_Event == null)
            throw new EventException("No se encuentra el evento");
        return ResponseEntity.ok(events);

    }

    @PostMapping("/AddEvents") 
    public Event addEvents(@RequestBody Event event){
        logger.info("Evento agregado" + event);
        return iEventService.addEvent(event);

    }

    @PatchMapping("/UpdateEvents/{id_Event}")
    public ResponseEntity <Event> editEvent(@PathVariable int id_Event, @RequestBody Event eventReceived){
        Event event = iEventService.findEvent(id_Event);
        if (event == null)
        throw new EventException("El id no existe");
        event.setName_Event(eventReceived.getName_Event());
        event.setStartTime_Event(eventReceived.getStartTime_Event());
        event.setEndTime_Event(eventReceived.getEndTime_Event());
        event.setDescription_Event(eventReceived.getDescription_Event());
        event.setState_Event(eventReceived.getState_Event());
        event.setCapacity_Event(eventReceived.getCapacity_Event());
        return ResponseEntity.ok(event);

    }
}


