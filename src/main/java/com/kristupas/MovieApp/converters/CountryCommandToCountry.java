package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.CountryCommand;
import com.kristupas.MovieApp.models.Country;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CountryCommandToCountry implements Converter<CountryCommand, Country> {


    @Synchronized
    @Nullable
    @Override
    public Country convert(CountryCommand countryCommand) {
        if(countryCommand == null)
            return null;
        final Country country = new Country();
        country.setName(countryCommand.getName());
        country.setIcon(countryCommand.getIcon());
        country.setId(countryCommand.getId());
        return country;
    }
}