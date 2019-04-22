package com.kristupas.MovieApp.services;


/**
 * Interface provides methods for working with Movie Collection
 * Such as retrieving values saving and deleting**/

import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.models.Movie;

import java.util.Set;

public interface MovieService  {

    Set<Movie> getMovies();

    Movie findById(Long l);

    MovieCommand saveMovieCommand(MovieCommand command);

    MovieCommand findCommandById(Long id);

    void deleteById(Long id);
}
