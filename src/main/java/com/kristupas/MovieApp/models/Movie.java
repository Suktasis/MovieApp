package com.kristupas.MovieApp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "notes")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private int length;
    private String url;
    private double rating;

    private String release;




    private Notes notes;

    @Enumerated(value = EnumType.STRING)
    private Age age;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "movie_country",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private Set<Country> countries = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private Set<Director> directors = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "movie_producer",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id"))
    private Set<Producer> producers  = new HashSet<>();

//    private Set<String> im = new HashSet<>();


    @Lob
    private Byte[] preview;




    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setMovie(this);
    }
    public void addCountry(Country country){
        countries.add(country);
//        country.addMovie(this);
    }

    public void addActor(Actor actor){
        actors.add(actor);
        actor.addMovie(this);
    }


}
