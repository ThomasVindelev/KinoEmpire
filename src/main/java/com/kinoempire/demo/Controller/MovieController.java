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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getGenres")
    public Object getGenres() {
        return movieService.getGenres();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addMovie")
    public Object addMovie(@RequestBody Movie movie) {
        Map<String, Boolean> message = new HashMap<>();
        message.put("Error", movieService.addMovie(movie));
        return message;
    }

    @GetMapping("/getMovieTitles")
    public Object getMovieTitles() {
        return movieService.getMovieTitles();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/updateMovie/{id}")
    public Object updateMovie(@RequestBody Movie movie, @PathVariable("id") int id) {
        Map<String, Boolean> message = new HashMap<>();
        System.out.println(id);
        message.put("Error", movieService.updateMovie(movie, id));
        return message;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteMovie/{id}")
    public Object deleteMovie(@PathVariable("id") int id) {
        Map<String, Boolean> message = new HashMap<>();
        message.put("Error", movieService.deleteMovie(id));
        return message;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/movies")
    public Object getMovies() {
        return movieService.getAllMovies();
    }

}
