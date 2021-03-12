package com.bootcamp.ejercicio1.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LinkDTO {
    private Integer id;
    private String url;
    private boolean valid = true;
    private int count;
    private String password = null;
}
