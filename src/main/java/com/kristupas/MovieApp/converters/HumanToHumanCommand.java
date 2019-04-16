package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.HumanCommand;
import com.kristupas.MovieApp.models.Human;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class HumanToHumanCommand implements Converter<Human, HumanCommand> {

    @Synchronized
    @Nullable
    @Override
    public HumanCommand convert(Human human) {
        if(human == null)
            return null;
        final HumanCommand humanCommand = new HumanCommand();
        humanCommand.setName(human.getName());
        humanCommand.setDateOfBirth(human.getDateOfBirth());
        humanCommand.setCountry(human.getCountry());
        humanCommand.setId(human.getId());
        humanCommand.setPreview(human.getPreview());

        return humanCommand;
    }
}
