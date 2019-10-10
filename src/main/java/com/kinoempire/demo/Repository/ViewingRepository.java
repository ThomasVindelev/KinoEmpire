package com.kinoempire.demo.Repository;

import com.kinoempire.demo.Model.Seat;
import com.kinoempire.demo.Model.Viewing;
import org.springframework.stereotype.Repository;

import javax.swing.text.View;
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
        query = "SELECT viewing.id, viewing.time, theater.id, theater.rows, theater.seats, movie.description, movie.title, movie.length, movie.age_limit, movie.img_url, genre.genre " +
                "FROM viewing " +
                "INNER JOIN theater ON viewing.fk_theater = theater.id " +
                "INNER JOIN movie ON viewing.fk_movie = movie.id " +
                "INNER JOIN genre ON movie.fk_genre = genre.id " +
                "WHERE viewing.id = ?";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, viewingId);
        return preparedStatement.executeQuery();

    }

    public boolean createViewing(Viewing viewing) throws SQLException {
        query = "INSERT INTO viewing (time, fk_movie, fk_theater) VALUES (?, ?, ?)";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(1, viewing.getDate());
        preparedStatement.setInt(2, viewing.getMid());
        preparedStatement.setInt(3, viewing.getTheaterId());
        return preparedStatement.execute();
    }

    public void reserveSeats(Seat seat, int viewingId) throws SQLException {
        query = "INSERT INTO seating (row, seat, fk_viewing) VALUES (?,?,?)";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, seat.getRow());
        preparedStatement.setInt(2, seat.getSeat());
        preparedStatement.setInt(3, viewingId);
        preparedStatement.execute();
    }
}
