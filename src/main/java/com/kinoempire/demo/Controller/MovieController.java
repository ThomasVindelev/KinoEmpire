package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Model.Movie;
import com.kinoempire.demo.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute Movie movie, Model model) {
        movieService.addMovie(movie);
        model.addAttribute("succes", true);
        return "index";
    }

    @DeleteMapping("/deleteMovie")
    public String deleteMovie(@PathVariable("id") int id, Model model) {
        movieService.deleteMovie(id);
        model.addAttribute("deleted", true);
        return "index";
    }

    @GetMapping("/movies")
    public String getMovies() {
        return "";
    }

}
