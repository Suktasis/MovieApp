package com.kristupas.MovieApp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(exclude = "movies")
public class Country {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Byte [] icon;


    private String name;

}