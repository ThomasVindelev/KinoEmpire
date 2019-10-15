package com.kinoempire.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
