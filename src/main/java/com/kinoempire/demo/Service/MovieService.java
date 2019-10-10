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
        try {
            return movieRepository.addMovie(movie);
        } catch (SQLException e) {
            return true;
        }
    }

    public boolean updateMovie(Movie movie, int id) {
        try {
            return movieRepository.updateMovie(movie, id);
        } catch (SQLException e) {
            return true;
        }
    }

    public boolean deleteMovie(int id) {
        try {
            return movieRepository.deleteMovie(id);
        } catch (SQLException e) {
            return true;
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try {
            resultSet = movieRepository.getAllMovies();
            while(resultSet.next()) {
                Movie movie = new Movie();
                Genre genre = new Genre();
                movie.setId(resultSet.getInt("movie.id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDescription(resultSet.getString("description"));
                movie.setAge_limit(resultSet.getInt("age_limit"));
                movie.setImg_url(resultSet.getString("img_url"));
                movie.setLength(resultSet.getInt("length"));
                genre.setId(resultSet.getInt("genre.id"));
                genre.setName(resultSet.getString("genre"));
                movie.setGenre(genre);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public Movie getMovieById(int id) {
        Movie movie = new Movie();
        Genre genre = new Genre();
        try {
            resultSet = movieRepository.getMovieById(id);
            if(resultSet.next()) {
                movie.setTitle(resultSet.getString("title"));
                movie.setDescription(resultSet.getString("description"));
                movie.setAge_limit(resultSet.getInt("age_limit"));
                movie.setImg_url(resultSet.getString("img_url"));
                movie.setLength(resultSet.getInt("length"));
                genre.setId(resultSet.getInt("genre.id"));
                genre.setName(resultSet.getString("genre"));
                movie.setGenre(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        try {
            resultSet = movieRepository.getGenres();
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setName(resultSet.getString("genre"));
                genre.setId(resultSet.getInt("id"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    public List<Movie> getMovieTitles() {
        List<Movie> movies = new ArrayList<>();
        try {
            resultSet = movieRepository.getMovieTitles();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
