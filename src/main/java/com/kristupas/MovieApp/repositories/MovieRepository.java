package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findByName(String name);

}
