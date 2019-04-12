package com.kristupas.MovieApp.controllers;


import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.services.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class MovieControllerTest {

    @Mock
    MovieService movieService;

    MovieController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new MovieController(movieService);

    }

    @Test
    public void testPage() throws Exception {
        Movie movie = new Movie();
        movie.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/movies/show/1")).andExpect(status().isOk())
                .andExpect(view().name("movies/show"));
    }
}
