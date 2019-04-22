package com.kristupas.MovieApp.controllers;

import com.kristupas.MovieApp.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/human")
public class PersonController {
    MovieService movieService;

    public PersonController(MovieService personService) {
        this.movieService = personService;
    }

    @GetMapping("/movie/{movieId}/actors")
    public String listActors(@PathVariable Long id, Model model){
        model.addAttribute("people", movieService.findCommandById(id));
        return "actors/list";
    }
}
