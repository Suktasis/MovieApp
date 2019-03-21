package com.kristupas.MovieApp.controllers;

import com.kristupas.MovieApp.models.Country;
import com.kristupas.MovieApp.repositories.CountryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CountryRepository country;

    public IndexController(CountryRepository country) {
        this.country = country;
    }

    @RequestMapping("/")
    public String indexPage(){
        Optional<Country> countryOptional = country.findByName("USA");
        System.out.println("country USA id is " + countryOptional.get().getId());
        return "index";
    }

}
