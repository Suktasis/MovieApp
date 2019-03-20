package com.kristupas.MovieApp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int lengthMin;
    private String url;
    private float rating;



    @OneToOne(cascade= CascadeType.ALL)
    private Synopsis synopsis;

    @Enumerated(value = EnumType.STRING)
    private Age age;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Actor> actor;

    @Lob
    private Byte[] preview;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public int getLengthMin() {
        return lengthMin;
    }

    public void setLengthMin(int lengthMin) {
        this.lengthMin = lengthMin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Synopsis getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(Synopsis synopsis) {
        this.synopsis = synopsis;
    }

    public Byte[] getPreview() {
        return preview;
    }

    public void setPreview(Byte[] preview) {
        this.preview = preview;
    }
}
