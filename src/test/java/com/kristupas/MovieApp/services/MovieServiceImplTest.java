package com.kristupas.MovieApp.services;

import com.kristupas.MovieApp.controllers.IndexController;
import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.repositories.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MovieServiceImplTest {

    MovieServiceImpl movieService;

    @Mock
    MovieRepository movieRepository;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        indexController = new IndexController(movieService);

    }

    @Test public void getMovieById(){
        Movie movie = new Movie();
        movie.setId(1L);

        Optional<Movie> optionalMovie = Optional.of(movie);

        when(movieRepository.findById(anyLong())).thenReturn(optionalMovie);

        Movie movieGot = movieService.findById(1L);

        assertEquals(movieGot.getId(),(Long)1L);

        verify(movieRepository,times(1)).findById(anyLong());
        verify(movieRepository,never()).findAll();
    }


    @Test
    public void getMovies() {
        Movie movie = new Movie();
        HashSet movieSetData = new HashSet();
        movieSetData.add(movie);

        when(movieService.getMovies()).thenReturn(movieSetData);

        Set<Movie> movies = movieService.getMovies();
        verify(movieRepository,times(1)).findAll();
    }

}