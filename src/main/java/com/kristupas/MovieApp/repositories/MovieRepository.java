package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    
}
