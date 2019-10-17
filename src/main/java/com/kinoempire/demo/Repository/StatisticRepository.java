package com.kinoempire.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;

@Repository
public class StatisticRepository extends Database {

    private PreparedStatement preparedStatement;
    private String query;

    public ResultSet getSoldSeats() throws SQLException {
        query = "SELECT COUNT(id) FROM seating";
        preparedStatement = getConnection().prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ResultSet getViewingCount() throws SQLException {
        query = "SELECT COUNT(id) FROM viewing";
        preparedStatement = getConnection().prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    // ALT HERUNDER ER TESTING AF TID

    public ResultSet getTime(Timestamp from, Timestamp to) throws SQLException {
        query = "SELECT id FROM viewing WHERE time BETWEEN ? AND ?";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setTimestamp(1, from);
        preparedStatement.setTimestamp(2, to);
        return preparedStatement.executeQuery();
    }
}
