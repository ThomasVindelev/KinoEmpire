package com.kinoempire.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ViewingRepository extends Database {

    private PreparedStatement preparedStatement;
    private String query;

    public ResultSet getSeatsByViewing(int viewingId) throws SQLException {
        query = "SELECT seat, row FROM seating WHERE fk_viewing = ?";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, viewingId);
        return preparedStatement.executeQuery();
    }

    public ResultSet getViewingById(int viewingId) throws SQLException {
        query = "SELECT viewing.id, viewing.time, theater.rows, theater.seats, movie.title, movie.length, movie.age_limit, movie.img_url, genre.genre " +
                "FROM viewing " +
                "INNER JOIN theater ON viewing.fk_theater = theater.id " +
                "INNER JOIN movie ON viewing.fk_movie = movie.id " +
                "INNER JOIN genre ON movie.fk_genre = genre.id " +
                "WHERE viewing.id = ?";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, viewingId);
        return preparedStatement.executeQuery();

    }
}
