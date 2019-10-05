package com.kinoempire.demo.Repository;

import com.kinoempire.demo.Model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MovieRepository extends Database {

    private PreparedStatement preparedStatement;
    private String query;

    public void addMovie(Movie movie) {
        query = "INSERT INTO movie (title, length, age_limit, fk_genre) VALUES (?,?,?,?)";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getLength());
            preparedStatement.setInt(3, movie.getAge_limit());
            preparedStatement.setInt(4, movie.getGenreId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie(int id) {
        query = "DELETE FROM movie WHERE id = ?";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllMovies() {
        query = "SELECT title, length, age_limit, genre" +
                "INNER JOIN genre ON fk_genre = genre.id";

        try {
            preparedStatement = getConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getMovieById(int id) {
        query = "SELECT title, length, age_limit, genre" +
                "INNER JOIN genre ON fk_genre = genre.id WHERE movie.id = ?";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
