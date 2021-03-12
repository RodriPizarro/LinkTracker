package com.bootcamp.ejercicio1.services;

import com.bootcamp.ejercicio1.DTOs.LinkDTO;
import com.bootcamp.ejercicio1.exceptions.InvalidLinkException;
import com.bootcamp.ejercicio1.exceptions.InvalidPasswordException;
import com.bootcamp.ejercicio1.exceptions.LinkNotFoundException;
import com.bootcamp.ejercicio1.repositories.IURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectService implements IRedirectService {
    @Autowired
    private final IURLRepository repository;

    public RedirectService(IURLRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDTO createLink(String url, String pass) {
        return repository.createLink(url, pass);
    }

    @Override
    public LinkDTO getLink(Integer id, String pass) throws LinkNotFoundException, InvalidLinkException, InvalidPasswordException {
        LinkDTO res = repository.getLink(id, pass);

        if( !res.isValid() )
            throw new InvalidLinkException();

        res.setCount(res.getCount() + 1);
        return res;
    }

    @Override
    public int getMetrics(Integer id, String pass) throws LinkNotFoundException, InvalidPasswordException {
        return repository.getMetrics(id, pass);
    }

    @Override
    public void invalidate(Integer id) throws LinkNotFoundException {
        repository.invalidate(id);
    }
}
