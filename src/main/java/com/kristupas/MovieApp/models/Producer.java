package com.kristupas.MovieApp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Producer extends Human {



    @ManyToMany(mappedBy = "producers")
    private Set<Movie> movies;


    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
