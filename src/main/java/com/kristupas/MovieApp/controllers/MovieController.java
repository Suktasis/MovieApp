package com.kristupas.MovieApp.controllers;

import com.kristupas.MovieApp.commands.MovieCommand;
import com.kristupas.MovieApp.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("movie",movieService.findById(new Long(id)));
        return "movies/show";
    }

    @GetMapping("new")
    public String newMovie(Model model){
        model.addAttribute("movie", new MovieCommand());
        return "movies/movieinput.html";
    }

    @PostMapping("movie")
    public String save(@ModelAttribute MovieCommand movieCommand){
        MovieCommand savedCommand = movieService.saveMovieCommand(movieCommand);

        return "redirect:/movies/show/" + savedCommand.getId();
    }

}
