package com.bootcamp.ejercicio1.exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends LinkException{
    public LinkNotFoundException() {
        super("El link solicitado no existe","El link solicitado no existe", HttpStatus.NOT_FOUND);
    }
}
