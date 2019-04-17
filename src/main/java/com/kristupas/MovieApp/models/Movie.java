package com.kristupas.MovieApp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(exclude = "description")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String url;
    private int length;
    private double rating;

    private Date release;




    private Description description;

    @Enumerated(value = EnumType.STRING)
    private Age age;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Human> humans = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "movie_country",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private Set<Country> countries = new HashSet<>();


//    private Set<String> im = new HashSet<>();


    @Lob
    private Byte[] preview;


    public void setDescription(Description description) {
        this.description = description;
        description.setMovie(this);
    }
    public void addCountry(Country country){
        countries.add(country);
    }

    public void addHuman(Human human){
        humans.add(human);
    }
}
