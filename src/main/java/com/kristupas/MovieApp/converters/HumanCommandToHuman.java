package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.HumanCommand;
import com.kristupas.MovieApp.models.Person;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class HumanCommandToHuman implements Converter<HumanCommand, Person> {



    @Synchronized
    @Nullable
    @Override
    public Person convert(HumanCommand humanCommand) {
        if(humanCommand == null)
            return null;
        final Person person = new Person();
        person.setName(humanCommand.getName());
        person.setDateOfBirth(humanCommand.getDateOfBirth());
        person.setCountry(humanCommand.getCountry());
        person.setId(humanCommand.getId());
        person.setPreview(humanCommand.getPreview());

        return person;
    }
}