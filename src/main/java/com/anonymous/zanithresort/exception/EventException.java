package com.anonymous.zanithresort.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventException extends RuntimeException {

    public EventException(String mensaje){
        super(mensaje);
        
    }

}
