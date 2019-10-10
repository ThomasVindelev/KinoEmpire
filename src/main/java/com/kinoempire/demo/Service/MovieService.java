package com.kinoempire.demo.Service;

import com.kinoempire.demo.Model.Genre;
import com.kinoempire.demo.Model.Movie;
import com.kinoempire.demo.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private ResultSet resultSet;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public boolean updateMovie(Movie movie, int id) {
        return movieRepository.updateMovie(movie, id);
    }

    public boolean deleteMovie(int id) {
        return movieRepository.deleteMovie(id);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        resultSet = movieRepository.getAllMovies();
        try {
            while(resultSet.next()) {
                Movie movie = new Movie();
                Genre genre = new Genre();
                movie.setTitle(resultSet.getString("title"));
                movie.setId(resultSet.getInt("movie.id"));
                movie.setDescription(resultSet.getString("description"));
                movie.setAge_limit(resultSet.getInt("age_limit"));
                movie.setImg_url(resultSet.getString("img_url"));
                movie.setLength(resultSet.getInt("length"));
                genre.setName(resultSet.getString("genre"));
                movie.setGenre(genre);
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Movie getMovieById(int id) {
        resultSet = movieRepository.getMovieById(id);
        Movie movie = new Movie();
        Genre genre = new Genre();
        try {
            if(resultSet.next()) {
                movie.setTitle(resultSet.getString("title"));
                movie.setDescription(resultSet.getString("description"));
                movie.setAge_limit(resultSet.getInt("age_limit"));
                movie.setImg_url(resultSet.getString("img_url"));
                movie.setLength(resultSet.getInt("length"));
                genre.setName(resultSet.getString("genre"));
                movie.setGenre(genre);
            }
            return movie;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Genre> getGenres() {
        resultSet = movieRepository.getGenres();
        List<Genre> genres = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setName(resultSet.getString("genre"));
                genre.setId(resultSet.getInt("id"));
                genres.add(genre);
            }
            return genres;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
