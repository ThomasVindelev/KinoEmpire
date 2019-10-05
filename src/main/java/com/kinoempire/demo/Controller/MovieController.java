package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addMovie")
    public String addMovie() {
        movieService.addMovie();
    }

}
