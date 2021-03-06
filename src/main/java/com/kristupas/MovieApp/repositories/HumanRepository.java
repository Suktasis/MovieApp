package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HumanRepository extends CrudRepository<Person, Long> {
    Optional<Person> findByName(String name);
}
