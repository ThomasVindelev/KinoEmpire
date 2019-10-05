package com.kinoempire.demo.Repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class MovieRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public void addMovie() {

    }


}
