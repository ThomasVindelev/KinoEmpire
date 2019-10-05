package com.kinoempire.demo.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://den1.mysql5.gear.host/KinoEmpire",
                    "kinoempire",
                    "Vc0Hz~9E!4bK");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
