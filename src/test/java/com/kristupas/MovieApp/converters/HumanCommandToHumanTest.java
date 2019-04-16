package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.HumanCommand;
import com.kristupas.MovieApp.models.Human;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanCommandToHumanTest {

    public static final Long id = 1L;
    public static final String name = "Joseph";

    HumanCommandToHuman converter;

    @Before
    public void setUp(){
        converter = new HumanCommandToHuman();
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new HumanCommand()));
    }

    @Test
    public void convert() throws Exception {
        HumanCommand humanCommand = new HumanCommand();
        humanCommand.setId(id);
        humanCommand.setName(name);

        Human human = converter.convert(humanCommand);

        assertEquals(id, human.getId());
        assertEquals(name, human.getName());
    }
}