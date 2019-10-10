package com.kinoempire.demo.Service;

import com.kinoempire.demo.Model.Theater;
import com.kinoempire.demo.Repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private ResultSet resultSet;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Object getTheater() {
        try {
            resultSet = theaterRepository.getTheater();
            List<Theater> theaters = new ArrayList<>();
            while (resultSet.next()) {
                Theater theater = new Theater();
                theater.setId(resultSet.getInt("id"));
                theater.setRows(resultSet.getInt("rows"));
                theater.setSeats(resultSet.getInt("seats"));
                theaters.add(theater);
            }
            return theaters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
