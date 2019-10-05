package com.kinoempire.demo.Service;

import com.kinoempire.demo.Repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie() {
        movieRepository.addMovie();
    }
}
