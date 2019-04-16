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
@RequestMapping("/")
public class IndexController {
    private MovieService movieService;

    public IndexController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String indexPage(Model model){
        log.debug("Getting index page");
        model.addAttribute("movies",movieService.getMovies());

        return "index";
    }

}
