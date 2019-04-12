package com.kristupas.MovieApp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Embeddable
@Data
@EqualsAndHashCode(exclude = "movie")
public class Notes {



    @Lob
    private String synopsis;



    private String slogan;



}
