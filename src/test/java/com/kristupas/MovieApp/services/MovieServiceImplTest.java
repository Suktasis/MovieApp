package com.kristupas.MovieApp.services;

import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.controllers.IndexController;
import com.kristupas.MovieApp.converters.*;
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

        MovieCommandToMovie movieCommandToMovie = new MovieCommandToMovie(new CountryCommandToCountry(),
                new HumanCommandToHuman());
        MovieToMovieCommand movieToMovieCommand = new MovieToMovieCommand(new CountryToCountryCommand(),
                new HumanToHumanCommand());


        movieService = new MovieServiceImpl(movieRepository, movieToMovieCommand, movieCommandToMovie);
        indexController = new IndexController(movieService);
    }

    @Test public void getMovieByIdTest(){
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
    public void getMoviesTest() {
        Movie movie = new Movie();
        HashSet movieSetData = new HashSet();
        movieSetData.add(movie);

        when(movieService.getMovies()).thenReturn(movieSetData);

        Set<Movie> movies = movieService.getMovies();
        verify(movieRepository,times(1)).findAll();
    }


    @Test
    public void deleteByIdTest(){
        Long id = 1L;
        movieService.deleteById(id);


        verify(movieRepository, times(1)).deleteById(anyLong());
    }


}