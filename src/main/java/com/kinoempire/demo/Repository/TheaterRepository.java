package com.kinoempire.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TheaterRepository extends Database {

    private PreparedStatement preparedStatement;
    private String query;

    public ResultSet getTheater() throws SQLException {
        query = "SELECT * FROM theater";
        preparedStatement = getConnection().prepareStatement(query);
        return preparedStatement.executeQuery();
    }

}
