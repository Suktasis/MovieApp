package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Actor;
import com.kristupas.MovieApp.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ActorRepository extends CrudRepository<Movie, Long> {

    Optional<Actor> findByName(String name);
}
