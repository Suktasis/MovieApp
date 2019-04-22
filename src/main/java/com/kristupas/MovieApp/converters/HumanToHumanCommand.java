package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.HumanCommand;
import com.kristupas.MovieApp.models.Person;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class HumanToHumanCommand implements Converter<Person, HumanCommand> {

    @Synchronized
    @Nullable
    @Override
    public HumanCommand convert(Person person) {
        if(person == null)
            return null;
        final HumanCommand humanCommand = new HumanCommand();
        humanCommand.setName(person.getName());
        humanCommand.setDateOfBirth(person.getDateOfBirth());
        humanCommand.setCountry(person.getCountry());
        humanCommand.setId(person.getId());
        humanCommand.setPreview(person.getPreview());

        return humanCommand;
    }
}
