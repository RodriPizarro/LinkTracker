package com.bootcamp.ejercicio1.services;

import com.bootcamp.ejercicio1.DTOs.LinkDTO;
import com.bootcamp.ejercicio1.repositories.IURLRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;

public class RedirectServiceTest {
    private RedirectService redirectService;

    @Mock
    private IURLRepository urlRepository;

    @BeforeEach
    public void setupRepository() {
        initMocks(this);
        this.redirectService = new RedirectService(this.urlRepository);
    }

    @Test
    public void createLink() {
        // Arrange
        LinkDTO expected = new LinkDTO();
        expected.setUrl("https://www.youtube.com");
        expected.setCount(0);
        expected.setPassword("asd");
        expected.setId(1);
        Mockito.when(urlRepository.createLink(any(String.class),any(String.class))).thenReturn(expected);

        // Act
        LinkDTO response = redirectService.createLink("https://www.youtube.com","asd");

        // Assert
        Assertions.assertSame(expected, response);
    }
}
