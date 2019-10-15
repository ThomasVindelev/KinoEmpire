package com.kinoempire.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StatisticRepository extends Database {

    private PreparedStatement preparedStatement;
    private String query;

    public ResultSet getSoldSeats(int viewingId) throws SQLException {
        query = "SELECT id FROM seating WHERE fk_viewing = ?";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, viewingId);
        return preparedStatement.executeQuery();
    }
}
