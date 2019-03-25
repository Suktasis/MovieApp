package com.kristupas.MovieApp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "movies")
public class Country {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToMany(mappedBy = "countries")
    private Set<Movie> movies;

    private String name;

}
