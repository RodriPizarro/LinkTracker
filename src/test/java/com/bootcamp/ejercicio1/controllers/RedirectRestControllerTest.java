package com.bootcamp.ejercicio1.controllers;

import com.bootcamp.ejercicio1.DTOs.LinkDTO;
import com.bootcamp.ejercicio1.repositories.IURLRepository;
import com.bootcamp.ejercicio1.repositories.URLRepeatedRepository;
import com.bootcamp.ejercicio1.services.IRedirectService;
import com.bootcamp.ejercicio1.services.RedirectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RedirectRestController.class)
public class RedirectRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IRedirectService redirectService;

    @Test
    public void createLink() throws Exception {
        LinkDTO expected = new LinkDTO();
        expected.setUrl("https://www.youtube.com");
        expected.setCount(1);
        expected.setPassword("asd");
        expected.setId(1);
        Mockito.when(redirectService.createLink(any(String.class),any(String.class)))
                .thenReturn(expected);
        
        mockMvc.perform(post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"url\": \"https://www.youtube.com\",\n" +
                        "    \"password\": \"asd\"\n" +
                        "}"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("1")));
    }
}
