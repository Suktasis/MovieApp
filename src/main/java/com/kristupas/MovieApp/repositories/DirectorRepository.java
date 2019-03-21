package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
