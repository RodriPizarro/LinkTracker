package com.bootcamp.ejercicio1.repositories;

import com.bootcamp.ejercicio1.DTOs.LinkDTO;
import com.bootcamp.ejercicio1.exceptions.InvalidPasswordException;
import com.bootcamp.ejercicio1.exceptions.LinkNotFoundException;

public interface IURLRepository {
    LinkDTO createLink(String url, String pass);
    LinkDTO getLink(Integer id, String pass) throws LinkNotFoundException, InvalidPasswordException;
    int getMetrics(Integer id, String pass) throws LinkNotFoundException, InvalidPasswordException;
    void invalidate(Integer id) throws LinkNotFoundException;
}
