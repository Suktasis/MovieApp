package com.kristupas.MovieApp.services;

import com.kristupas.MovieApp.models.Movie;
import com.kristupas.MovieApp.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Set<Movie> getMovies() {
        Set<Movie> set = new HashSet<>();
        movieRepository.findAll().iterator().forEachRemaining(set::add);
        return set;
    }
}
