package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<Country> findByName(String name);

}
