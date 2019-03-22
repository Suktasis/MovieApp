package com.kristupas.MovieApp.controllers;

import com.kristupas.MovieApp.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private MovieService movieService;

    public IndexController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/")
    public String indexPage(Model model){

        model.addAttribute("movies",movieService.getMovies());

        return "index";
    }

}
