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

    public List<Theater> getTheater() {
        List<Theater> theaters = new ArrayList<>();
        try {
            resultSet = theaterRepository.getTheater();
            while (resultSet.next()) {
                Theater theater = new Theater();
                theater.setId(resultSet.getInt("id"));
                theater.setRows(resultSet.getInt("rows"));
                theater.setSeats(resultSet.getInt("seats"));
                theaters.add(theater);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theaters;
    }

    public List<Integer> getTheaterRowsById(int id) {
        List<Integer> rowsList = new ArrayList<>();

        try {
            resultSet = theaterRepository.getTheaterById(id);
            int rows = 0;
            while(resultSet.next()) {
                rows = resultSet.getInt("rows");
            }

            for(int i = 1; i <= rows; i++) {
                rowsList.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsList;
    }

    public List<Integer> getTheaterSeatsById(int id) {
        List<Integer> seatsList = new ArrayList<>();

        try {
            resultSet = theaterRepository.getTheaterById(id);
            int seats = 0;
            while(resultSet.next()) {
                seats = resultSet.getInt("seats");
            }

            for(int i = 1; i <= seats; i++) {
                seatsList.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatsList;
    }
}
