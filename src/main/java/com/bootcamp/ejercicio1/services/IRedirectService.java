package com.bootcamp.ejercicio1.services;

import com.bootcamp.ejercicio1.DTOs.LinkDTO;
import com.bootcamp.ejercicio1.exceptions.InvalidLinkException;
import com.bootcamp.ejercicio1.exceptions.InvalidPasswordException;
import com.bootcamp.ejercicio1.exceptions.LinkNotFoundException;

public interface IRedirectService {
    LinkDTO createLink(String url, String pass);
    LinkDTO getLink(Integer id, String pass) throws LinkNotFoundException, InvalidLinkException, InvalidPasswordException;
    int getMetrics(Integer id, String pass) throws LinkNotFoundException, InvalidPasswordException;
    void invalidate(Integer id) throws LinkNotFoundException;
}
