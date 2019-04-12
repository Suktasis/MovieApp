package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Optional<Genre> findByName(String name);
}