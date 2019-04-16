package com.kristupas.MovieApp.services;


import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.converters.MovieCommandToMovie;
import com.kristupas.MovieApp.converters.MovieToMovieCommand;
import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.repositories.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceInsertTest {

    public final static String URL = "com.example";

    @Autowired
    MovieService movieService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieToMovieCommand movieToMovieCommand;

    @Autowired
    MovieCommandToMovie movieCommandToMovie;

    @Transactional
    @Test
    public void testWork() {
        Iterable<Movie> movies = movieRepository.findAll();
        Movie movie = movies.iterator().next();
        MovieCommand movieCommand = movieToMovieCommand.convert(movie);

        movieCommand.setUrl(URL);
        MovieCommand savedMovieCommand = movieService.saveMovieCommand(movieCommand);

        assertEquals(URL,savedMovieCommand.getUrl());
        assertEquals(movie.getId(),savedMovieCommand.getId());
        assertEquals(movie.getHumans().size(),savedMovieCommand.getHumans().size());
        assertEquals(movie.getCountries().size(),savedMovieCommand.getCountries().size());
    }
}
