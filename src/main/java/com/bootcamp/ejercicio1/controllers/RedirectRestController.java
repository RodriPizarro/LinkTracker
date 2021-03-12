package com.bootcamp.ejercicio1.controllers;

import com.bootcamp.ejercicio1.DTOs.ExceptionDTO;
import com.bootcamp.ejercicio1.DTOs.LinkDTO;
import com.bootcamp.ejercicio1.DTOs.LinkRequestDTO;
import com.bootcamp.ejercicio1.UrlValidator;
import com.bootcamp.ejercicio1.exceptions.*;
import com.bootcamp.ejercicio1.services.IRedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RedirectRestController {

    private final IRedirectService redirectService;

    public RedirectRestController(IRedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @PostMapping("/create")
    public int create(@RequestBody LinkRequestDTO req) throws BadLinkRequestException {
        if( req == null || req.getUrl() == null || !UrlValidator.validate(req.getUrl()) )
            throw new BadLinkRequestException();

        return redirectService.createLink(req.getUrl(), req.getPassword()).getId();
    }

    @GetMapping("/link/{linkId}")
    public ModelAndView redirect(@PathVariable String linkId, @RequestParam(required = false) String password) throws LinkNotFoundException, InvalidLinkException, InvalidPasswordException {
        int id = Integer.parseInt(linkId);
        LinkDTO link = redirectService.getLink(id, password);
        String url = link.getUrl();
        return new ModelAndView("redirect:" + url);
    }

    @GetMapping("/metrics/{linkId}")
    public int metrics(@PathVariable String linkId, @RequestParam(required = false) String password) throws LinkNotFoundException, InvalidPasswordException  {
        int id = Integer.parseInt(linkId);
        return redirectService.getMetrics(id, password);
    }

    @PostMapping("/invalidate/{linkId}")
    public void invalidate(@PathVariable String linkId) throws LinkNotFoundException{
        int id = Integer.parseInt(linkId);
        redirectService.invalidate(id);
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid id format")
    @ExceptionHandler(NumberFormatException.class)
    public void idFormatHandler() {
        System.out.println("Invalid id format");
    }

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ExceptionDTO> linkExceptionHandler(LinkException e) {
        return new ResponseEntity<>(e.getException(),e.getStatus());
    }
}
