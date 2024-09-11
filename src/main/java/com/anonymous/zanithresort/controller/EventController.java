package com.anonymous.zanithresort.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anonymous.zanithresort.exception.EventException;
import com.anonymous.zanithresort.model.Event;
import com.anonymous.zanithresort.services.IEventService;

import com.anonymous.zanithresort.exception.EventException;
import com.anonymous.zanithresort.services.IEventService;
import com.anonymous.zanithresort.model.Event;


@RequestMapping("/Events/v1")
public class EventController {
    
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private IEventService iEventService;

    @GetMapping("/ListEvents")
    public List<Event> listEvents() {
        var event2 = iEventService.listEvent();
        event2.forEach(events -> logger.info(events.toString()));
        return event2;

}
