package com.kristupas.MovieApp.models;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "movies")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    @ManyToMany
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

}
