package com.kristupas.MovieApp.controllers;


import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.services.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovieControllerTest {

    @Mock
    MovieService movieService;

    MovieController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new MovieController(movieService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void showMovieTest() throws Exception {
        Movie movie = new Movie();
        movie.setId(1L);
        mockMvc.perform(get("/movies/1/show")).andExpect(status().isOk())
                .andExpect(view().name("movies/show"))
                .andExpect(model().attributeExists("movie"));
    }

    @Test
    public void deleteMovieTest() throws Exception {

        mockMvc.perform(get("/movies/1/delete"))
                .andExpect(view().name("redirect:/"))
                .andExpect(status().is3xxRedirection());

        verify(movieService, times(1)).deleteById(anyLong());
    }



    @Test
    public void updateMovieTest() throws Exception{
        MovieCommand movieCommand = new MovieCommand();
        movieCommand.setId(1L);

        when(movieService.findCommandById(anyLong())).thenReturn(movieCommand);

        mockMvc.perform(get("/movies/1/edit")).andExpect(status().isOk())
        .andExpect(view().name("movies/movieinput.html"))
        .andExpect(model().attributeExists("movie"));
    }

    @Test
    public void addMovieTest() throws Exception {
        MovieCommand movieCommand = new MovieCommand();
        movieCommand.setId(100L);
        when(movieService.saveMovieCommand(any())).thenReturn(movieCommand);

        mockMvc.perform(post("/movies/editer").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id",""))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/movies/100/show"));
        verify(movieService, times(1)).saveMovieCommand(any());
    }
}
