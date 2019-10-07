package com.kinoempire.demo.Service;

import com.kinoempire.demo.Model.Seat;
import com.kinoempire.demo.Model.Viewing;
import com.kinoempire.demo.Repository.SeatingRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SeatingService {

    private SeatingRepository seatingRepository;

    public SeatingService(SeatingRepository seatingRepository) {
        this.seatingRepository = seatingRepository;
    }

    public Viewing getSeatsByViewing(int id) {
        Viewing viewing = new Viewing();
        try {
            ResultSet resultSet = seatingRepository.getSeatsByViewing(id);
            while (resultSet.next()) {
                Seat seat = new Seat();
                seat.setSeat(resultSet.getInt("seat"));
                seat.setRow(resultSet.getInt("row"));
                viewing.setSeating(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewing;
    }

}
