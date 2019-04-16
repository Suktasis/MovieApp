package com.kristupas.MovieApp.models;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Description {



    @Lob
    private String synopsis;



    private String slogan;

    @OneToOne
    private Movie movie;

}
