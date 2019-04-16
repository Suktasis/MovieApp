package com.kristupas.MovieApp.commands;

import com.kristupas.MovieApp.models.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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
    private Date release;
    private Description description;
    private Age age;
    private Set<CountryCommand> countries = new HashSet<>();
    private Set<HumanCommand> humans  = new HashSet<>();

    @Lob
    private Byte[] preview;

    public void addHuman(HumanCommand human){
        humans.add(human);
    }

    public void addCountry(CountryCommand country){
        countries.add(country);
    }
}
