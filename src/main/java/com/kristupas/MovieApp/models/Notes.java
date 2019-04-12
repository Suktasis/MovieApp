package com.kristupas.MovieApp.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Lob
    private String synopsis;



    private String slogan;

    @OneToOne
    private Movie movie;

}
