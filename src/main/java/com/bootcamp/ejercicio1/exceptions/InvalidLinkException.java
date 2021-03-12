package com.bootcamp.ejercicio1.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLinkException extends LinkException {
    public InvalidLinkException() {
        super("Link inválido","El link solicitado fue invalidado", HttpStatus.BAD_REQUEST);
    }
}
