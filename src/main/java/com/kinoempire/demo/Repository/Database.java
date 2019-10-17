package com.kinoempire.demo.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/kinoempire?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&autoReconnect=true",
                    "kinoempire",
                    "Vc0Hz~9E!4bK");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
