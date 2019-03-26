package com.kristupas.MovieApp.repositories;

import com.kristupas.MovieApp.models.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryIT {

    @Autowired
    CountryRepository countryRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void name() {
        Optional<Country> country = countryRepository.findByName("USA");
        assertEquals("USA",country.get().getName());
    }
}