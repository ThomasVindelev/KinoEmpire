package com.kinoempire.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SeatingRepository extends Database {

    private PreparedStatement preparedStatement;
    private String query;

    public ResultSet getSeatsByViewing(int id) throws SQLException {
        query = "SELECT seat, row FROM seating WHERE fk_viewing = ?";
        preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }
}
