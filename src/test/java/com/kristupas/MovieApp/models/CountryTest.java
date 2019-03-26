package com.kristupas.MovieApp.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryTest {

    Country country;

    @Before
    public void init(){
        country = new Country();
    }

    @Test
    public void getId() {
        Long idVal = 4l;
        country.setId(idVal);
        assertEquals(idVal,country.getId());
    }

    @Test
    public void setId() {
    }

    @Test
    public void setMovies() {
    }
}