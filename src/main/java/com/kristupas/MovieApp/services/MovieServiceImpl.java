package com.kristupas.MovieApp.services;

import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Set<Movie> getMovies() {
        log.debug("Service works");
        Set<Movie> set = new HashSet<>();
        movieRepository.findAll().iterator().forEachRemaining(set::add);
        return set;
    }

}
