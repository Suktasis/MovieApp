package com.kristupas.MovieApp.controllers;

import com.kristupas.MovieApp.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/movies/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("movie",movieService.findById(new Long(id)));
        return "movies/show";
    }

}
