package com.kristupas.MovieApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
public class Director extends Human {


    @ManyToMany(mappedBy = "directors")
    private Set<Movie> movies;

}
