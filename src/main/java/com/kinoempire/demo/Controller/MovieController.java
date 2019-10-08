package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Model.Movie;
import com.kinoempire.demo.Service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getGenres")
    public Object getGenres() {
        return movieService.getGenres();
    }

    @PostMapping("/addMovie")
    public Object addMovie(@RequestBody Movie movie) {
        Map<String, Boolean> message = new HashMap<>();
        System.out.println(movie.getTitle());
        message.put("Error", movieService.addMovie(movie));
        return message;
    }

    @PostMapping("/updateMovie/{id}")
    public Object updateMovie(@RequestBody Movie movie, @PathVariable("id") int id) {
        Map<String, Boolean> message = new HashMap<>();
        System.out.println(movie.getTitle());
        message.put("Error", movieService.updateMovie(movie, id));
        return message;
    }

    @DeleteMapping("/deleteMovie/{id}")
    public Object deleteMovie(@PathVariable("id") int id) {
        Map<String, Boolean> message = new HashMap<>();
        message.put("Error", movieService.deleteMovie(id));
        return message;
    }

    @GetMapping("/movies")
    public Object getMovies() {
        return movieService.getAllMovies();
    }

}
