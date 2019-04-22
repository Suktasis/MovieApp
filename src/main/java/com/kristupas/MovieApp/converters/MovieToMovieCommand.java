package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.models.Country;
import com.kristupas.MovieApp.models.Person;
import com.kristupas.MovieApp.models.Movie;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class MovieToMovieCommand implements Converter<Movie, MovieCommand> {

    private final CountryToCountryCommand countryToCountryCommand;
    private final HumanToHumanCommand humanToHumanCommand;


    public MovieToMovieCommand(CountryToCountryCommand countryToCountryCommand, HumanToHumanCommand humanToHumanCommand) {
        this.countryToCountryCommand = countryToCountryCommand;
        this.humanToHumanCommand = humanToHumanCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public MovieCommand convert(Movie movie) {
        if(movie == null)
            return null;
        final MovieCommand movieCommand = new MovieCommand();
        movieCommand.setAge(movie.getAge());
        movieCommand.setId(movie.getId());
        movieCommand.setLength(movie.getLength());
        movieCommand.setName(movie.getName());
        movieCommand.setRating(movie.getRating());
        movieCommand.setUrl(movie.getUrl());
        movieCommand.setRelease(movie.getRelease());
        movieCommand.setPreview(movie.getPreview());
        movieCommand.setDescription(movie.getDescription());
        movieCommand.setAge(movie.getAge());

        if (movie.getPeople() != null && movie.getPeople().size() > 0){
            movie.getPeople()
                    .forEach((Person person) -> movieCommand.getHumans().add(humanToHumanCommand.convert(person)));
        }

        if (movie.getCountries() != null && movie.getCountries().size() > 0){
            movie.getCountries()
                    .forEach((Country country) -> movieCommand.getCountries().add(countryToCountryCommand.convert(country)));
        }

        return movieCommand;
    }
}
