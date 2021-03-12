package com.bootcamp.ejercicio1.repositories;

import com.bootcamp.ejercicio1.DTOs.LinkDTO;
import com.bootcamp.ejercicio1.exceptions.InvalidPasswordException;
import com.bootcamp.ejercicio1.exceptions.LinkNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class URLRepeatedRepository implements IURLRepository {
    private final Map<Integer,LinkDTO> struct = new HashMap<>();
    static int count = 1;

    @Override
    public LinkDTO createLink(String url, String pass) {
        LinkDTO link = new LinkDTO();

        link.setUrl(url);
        link.setPassword(pass);
        link.setId(count++);

        struct.put(link.getId(),link);

        return link;
    }

    @Override
    public LinkDTO getLink(Integer id, String pass) throws LinkNotFoundException, InvalidPasswordException {
        LinkDTO res = struct.get(id);

        if( res == null )
            throw new LinkNotFoundException();

        if( !res.getPassword().equals(pass) ) {
            throw new InvalidPasswordException();
        }

        return res;
    }

    @Override
    public int getMetrics(Integer id, String pass) throws LinkNotFoundException, InvalidPasswordException {
        LinkDTO aux = struct.get(id);

        if( aux == null )
            throw new LinkNotFoundException();

        if( !aux.getPassword().equals(pass) ) {
            throw new InvalidPasswordException();
        }

        return aux.getCount();
    }

    @Override
    public void invalidate(Integer id) throws LinkNotFoundException {
        LinkDTO aux = struct.get(id);

        if( aux == null )
            throw new LinkNotFoundException();

        aux.setValid(false);
    }


}
