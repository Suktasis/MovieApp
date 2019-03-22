package com.kristupas.MovieApp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor extends Human {


    @ManyToMany(mappedBy = "actors",cascade = CascadeType.ALL)
    private Set<Movie> movies;


    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


}
