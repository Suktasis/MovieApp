package com.kristupas.MovieApp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
public class Producer extends Human {



    @ManyToMany(mappedBy = "producers")
    private Set<Movie> movies;

}
