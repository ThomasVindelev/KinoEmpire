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

    public boolean addMovie(Movie movie) throws SQLException {
        query = "INSERT INTO movie (title, description, length, age_limit, fk_genre, img_url) VALUES (?,?,?,?,?,?)";

            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setInt(3, movie.getLength());
            preparedStatement.setInt(4, movie.getAge_limit());
            preparedStatement.setInt(5, movie.getGenreId());
            preparedStatement.setString(6, movie.getImg_url());
            return preparedStatement.execute();

        return true;
    }

    public boolean updateMovie(Movie movie, int id) throws SQLException {
        query = "UPDATE movie SET title = ?, length = ?, description = ?, age_limit = ?, fk_genre = ? WHERE id = ?";

            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getLength());
            preparedStatement.setInt(3, movie.getAge_limit());
            preparedStatement.setInt(5, id);
            return preparedStatement.execute();

        return true;
    }

    public boolean deleteMovie(int id) throws SQLException {
        query = "DELETE FROM movie WHERE id = ?";

            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();

        return true;
    }

    public ResultSet getAllMovies() throws SQLException {
        query = "SELECT movie.id, description, title, length, age_limit, img_url, genre.id, genre FROM movie " +
                "INNER JOIN genre ON movie.fk_genre = genre.id";

            preparedStatement = getConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
    }

    public ResultSet getMovieById(int id) throws SQLException {
        query = "SELECT title, description, length, age_limit, img_url, genre.id, genre " +
                "INNER JOIN genre ON fk_genre = genre.id WHERE movie.id = ?";

            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeQuery();
    }


    public ResultSet getGenres() throws SQLException {
        query = "SELECT * FROM genre";

            preparedStatement = getConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
    }

    public ResultSet getMovieTitles() throws SQLException {
        query = "SELECT id, title FROM movies";

            preparedStatement = getConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
    }
}
