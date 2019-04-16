package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.HumanCommand;
import com.kristupas.MovieApp.models.Human;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class HumanCommandToHuman implements Converter<HumanCommand, Human> {



    @Synchronized
    @Nullable
    @Override
    public Human convert(HumanCommand humanCommand) {
        if(humanCommand == null)
            return null;
        final Human human = new Human();
        human.setName(humanCommand.getName());
        human.setDateOfBirth(humanCommand.getDateOfBirth());
        human.setCountry(humanCommand.getCountry());
        human.setId(humanCommand.getId());
        human.setPreview(humanCommand.getPreview());

        return human;
    }
}