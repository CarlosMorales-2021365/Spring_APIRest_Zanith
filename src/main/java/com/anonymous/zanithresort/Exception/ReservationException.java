package com.anonymous.zanithresort.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReservationException extends RuntimeException{
    
    public ReservationException(String mensaje){
        super(mensaje);
    }
}
