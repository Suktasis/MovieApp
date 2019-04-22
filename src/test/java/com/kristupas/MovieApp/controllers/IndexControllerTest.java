package com.kristupas.MovieApp.controllers;

import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.services.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    MovieService movieService;

    @Mock
    Model model;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(movieService);
    }

    @Test
    public void indexPage() {

        Set<Movie> movies = new HashSet<>();
        movies.add(new Movie());
        Movie movie = new Movie();
        movie.setId(500L);
        movies.add(movie);

        when(movieService.getMovies()).thenReturn(movies);
        ArgumentCaptor<Set<Movie>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        assertEquals("index",indexController.indexPage(model));
        verify(model,times(1)).addAttribute(eq("movies"),argumentCaptor.capture());
        verify(movieService,times(1)).getMovies();
        Set<Movie> movieSet2 = argumentCaptor.getValue();
        assertEquals(2,movieSet2.size());
    }
}