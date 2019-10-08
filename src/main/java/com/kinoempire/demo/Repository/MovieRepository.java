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

    public boolean addMovie(Movie movie) {
        query = "INSERT INTO movie (title, description, length, age_limit, fk_genre) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setInt(3, movie.getLength());
            preparedStatement.setInt(4, movie.getAge_limit());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateMovie(Movie movie, int id) {
        query = "UPDATE movie SET title = ?, length = ?, description = ?, age_limit = ?, fk_genre = ? WHERE id = ?";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getLength());
            preparedStatement.setInt(3, movie.getAge_limit());
            preparedStatement.setInt(5, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteMovie(int id) {
        query = "DELETE FROM movie WHERE id = ?";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ResultSet getAllMovies() {
        query = "SELECT movie.id, description, title, length, age_limit, genre FROM movie " +
                "INNER JOIN genre ON movie.fk_genre = genre.id";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getMovieById(int id) {
        query = "SELECT title, description, length, age_limit, genre " +
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


    public ResultSet getGenres() {
        query = "SELECT * FROM genre";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
