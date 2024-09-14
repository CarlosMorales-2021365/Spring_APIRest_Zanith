package com.anonymous.zanithresort.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


