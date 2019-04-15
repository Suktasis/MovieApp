package com.kristupas.MovieApp.commands;

import com.kristupas.MovieApp.models.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MovieCommand {

    private Long Id;

    private String name;
    private int length;
    private String url;
    private double rating;
    private String release;
    private Notes notes;
    private Age age;
    private Set<Actor> actors = new HashSet<>();
    private Set<Country> countries = new HashSet<>();
    private Set<Director> directors = new HashSet<>();
    private Set<Producer> producers  = new HashSet<>();

    @Lob
    private Byte[] preview;
}
