package com.kristupas.MovieApp.converters;

import com.kristupas.MovieApp.commands.CountryCommand;
import com.kristupas.MovieApp.commands.HumanCommand;
import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.models.Description;
import com.kristupas.MovieApp.models.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MovieCommandToMovieTest {

    private MovieCommandToMovie movieCommandToMovie;

    private static final String NAME = "Inception";
    private static final String URL = "www.example.com";
    private static final Long ID = 1L;
    private static final int LENGTH = 130;
    private static final double RATING = 8.5;
    private static final Date RELEASE = new Date();
    private static final String SLOGAN = "die, or live";
    private static final Long HUMAN1_ID = 3L;
    private static final Long HUMAN2_ID = 4L;
    private static final Long COUNTRY_ID = 5L;


    @Before
    public void setUp(){
        movieCommandToMovie = new MovieCommandToMovie(new CountryCommandToCountry(), new HumanCommandToHuman());

    }

    @Test
    public void testNullObj(){
        assertNull(movieCommandToMovie.convert(null));
    }


    @Test
    public void testEmptyObj(){
        assertNotNull(movieCommandToMovie.convert(new MovieCommand()));
    }

    @Test
    public void convertTest(){
        MovieCommand movieCommand = new MovieCommand();
        movieCommand.setRelease(RELEASE);
        movieCommand.setRating(RATING);
        movieCommand.setId(ID);
        movieCommand.setLength(LENGTH);
        movieCommand.setName(NAME);
        movieCommand.setUrl(URL);

        Description description = new Description();
        description.setSlogan(SLOGAN);
        movieCommand.setDescription(description);

        HumanCommand human = new HumanCommand();
        human.setId(HUMAN1_ID);
        HumanCommand human2 = new HumanCommand();
        human.setId(HUMAN1_ID);
        human2.setId(HUMAN2_ID);

        CountryCommand country = new CountryCommand();
        country.setId(COUNTRY_ID);
        movieCommand.addCountry(country);

        movieCommand.addHuman(human);
        movieCommand.addHuman(human2);

        Movie movie = movieCommandToMovie.convert(movieCommand);

        assertNotNull(movie);
        assertEquals(movie.getId(),ID);
        assertEquals(movie.getDescription().getSlogan(),SLOGAN);
        assertEquals(movie.getLength(),LENGTH);
        assertEquals(movie.getRelease(),RELEASE);
        assertEquals(movie.getUrl(),URL);
        assertEquals(movie.getHumans().size(), 2);

    }

}