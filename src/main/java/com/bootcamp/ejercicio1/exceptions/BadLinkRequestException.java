package com.bootcamp.ejercicio1.exceptions;

import org.springframework.http.HttpStatus;

public class BadLinkRequestException extends LinkException {
    public BadLinkRequestException() {
        super("Datos erroneos", "El formato o los valores enviados no son correctos", HttpStatus.BAD_REQUEST);
    }
}
