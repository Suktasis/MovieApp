package com.kristupas.MovieApp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Actor extends Human {



    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

}
