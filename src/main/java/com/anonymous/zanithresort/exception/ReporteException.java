package com.anonymous.zanithresort.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReporteException extends RuntimeException{

    public ReporteException(String mensaje){
        super(mensaje);
        }

}
