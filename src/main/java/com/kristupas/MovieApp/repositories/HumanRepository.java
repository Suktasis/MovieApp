package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Human;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HumanRepository extends CrudRepository<Human, Long> {
    Optional<Human> findByName(String name);
}
