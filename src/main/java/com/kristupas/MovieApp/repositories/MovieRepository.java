package com.kristupas.MovieApp.repositories;

/** Interface provides methods for movie collection
 * extends crudRepository therefore necessary methods are added by default **/

import com.kristupas.MovieApp.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findByName(String name);

    void deleteById(Long id);

}
