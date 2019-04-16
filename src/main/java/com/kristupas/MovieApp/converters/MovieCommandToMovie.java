package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.CountryCommand;
import com.kristupas.MovieApp.commands.HumanCommand;
import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.models.Movie;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class MovieCommandToMovie implements Converter<MovieCommand, Movie> {

    private final CountryCommandToCountry countryCommandToCountry;
    private final HumanCommandToHuman humanCommandToHuman;

    public MovieCommandToMovie(CountryCommandToCountry countryCommandToCountry, HumanCommandToHuman humanCommandToHuman) {
        this.countryCommandToCountry = countryCommandToCountry;
        this.humanCommandToHuman = humanCommandToHuman;
    }

    @Synchronized
    @Nullable
    @Override
    public Movie convert(MovieCommand movieCommand) {
        if(movieCommand == null)
            return null;
        final Movie movie = new Movie();
        movie.setAge(movieCommand.getAge());
        movie.setId(movieCommand.getId());
        movie.setLength(movieCommand.getLength());
        movie.setName(movieCommand.getName());
        movie.setRating(movieCommand.getRating());
        movie.setUrl(movieCommand.getUrl());
        movie.setRelease(movieCommand.getRelease());
        movie.setPreview(movieCommand.getPreview());
        movie.setDescription(movieCommand.getDescription());
        movie.setAge(movieCommand.getAge());
        if (movieCommand.getHumans() != null && movieCommand.getHumans().size() > 0){
            movieCommand.getHumans()
                    .forEach((HumanCommand human) -> movie.getHumans().add(humanCommandToHuman.convert(human)));
        }

        if (movieCommand.getCountries() != null && movieCommand.getCountries().size() > 0){
            movieCommand.getCountries()
                    .forEach((CountryCommand country) -> movie.getCountries().add(countryCommandToCountry.convert(country)));
        }

        return movie;
    }
}