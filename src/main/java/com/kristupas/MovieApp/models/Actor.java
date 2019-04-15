package com.kristupas.MovieApp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "movies")
public class Actor extends Human {



    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }
}
