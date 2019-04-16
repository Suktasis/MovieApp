package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.CountryCommand;
import com.kristupas.MovieApp.models.Country;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CountryToCountryCommand implements Converter<Country, CountryCommand> {



    @Synchronized
    @Nullable
    @Override
    public CountryCommand convert(Country country) {
        if(country == null)
            return null;
        final CountryCommand countryCommand = new CountryCommand();
        countryCommand.setName(country.getName());
        countryCommand.setIcon(country.getIcon());
        countryCommand.setId(country.getId());
        return countryCommand;
    }
}
