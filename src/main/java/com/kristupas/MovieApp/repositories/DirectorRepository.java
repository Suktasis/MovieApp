package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DirectorRepository extends CrudRepository<Director, Long> {
    Optional<Director> findByName(String name);
}
