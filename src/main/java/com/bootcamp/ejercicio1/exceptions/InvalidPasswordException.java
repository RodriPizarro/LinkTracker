package com.bootcamp.ejercicio1.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends LinkException {
    public InvalidPasswordException() {
        super("Contraseña incorrecta","La contraseña ingresada no es válida", HttpStatus.UNAUTHORIZED);
    }
}
