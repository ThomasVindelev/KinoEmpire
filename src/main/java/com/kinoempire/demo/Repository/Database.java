package com.kinoempire.demo.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {

    public Connection getConnection() {
        try {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
