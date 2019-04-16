package com.kristupas.MovieApp.services;


import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.models.Movie;

import java.util.Set;

public interface MovieService  {

    Set<Movie> getMovies();

    Movie findById(Long l);

    MovieCommand saveMovieCommand(MovieCommand command);
}
