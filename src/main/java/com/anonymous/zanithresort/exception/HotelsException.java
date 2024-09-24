package com.anonymous.zanithresort.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HotelsException extends RuntimeException {

    public HotelsException(String mensaje){
        super(mensaje);
        }
}
