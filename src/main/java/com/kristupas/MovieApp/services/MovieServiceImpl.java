package com.kristupas.MovieApp.services;

import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.converters.MovieCommandToMovie;
import com.kristupas.MovieApp.converters.MovieToMovieCommand;
import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private MovieCommandToMovie movieCommandToMovie;
    private MovieToMovieCommand movieToMovieCommand;

    public MovieServiceImpl(MovieRepository movieRepository, MovieToMovieCommand movieToMovieCommand,
                            MovieCommandToMovie movieCommandToMovie) {
        this.movieRepository = movieRepository;
        this.movieCommandToMovie = movieCommandToMovie;
        this.movieToMovieCommand = movieToMovieCommand;
    }

    @Override
    public Set<Movie> getMovies() {
        log.debug("Service works");
        Set<Movie> set = new HashSet<>();
        movieRepository.findAll().iterator().forEachRemaining(set::add);
        return set;
    }

    @Override
    public Movie findById(Long l) {
        Optional<Movie> optionalMovie = movieRepository.findById(l);
        if(!optionalMovie.isPresent()){
            throw new RuntimeException("Movie not found");
        }
        return optionalMovie.get();
    }

    @Override
    @Transactional
    public MovieCommand saveMovieCommand(MovieCommand command) {
        Movie detachedMovie = movieCommandToMovie.convert(command);

        Movie savedMovie = movieRepository.save(detachedMovie);
        return movieToMovieCommand.convert(savedMovie);
    }


}
