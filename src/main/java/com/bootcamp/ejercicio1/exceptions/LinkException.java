package com.bootcamp.ejercicio1.exceptions;

import com.bootcamp.ejercicio1.DTOs.ExceptionDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class LinkException extends Exception {
    private final ExceptionDTO exception;
    private final HttpStatus status;
    
    protected LinkException(String title, String description, HttpStatus status) {
        exception = new ExceptionDTO();
        exception.setTitle(title);
        exception.setDescription(description);
        this.status = status;
    }
}
