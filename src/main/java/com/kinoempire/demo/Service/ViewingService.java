package com.kinoempire.demo.Service;

import com.kinoempire.demo.Model.Seat;
import com.kinoempire.demo.Model.Viewing;
import com.kinoempire.demo.Repository.ViewingRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ViewingService {

    private ViewingRepository viewingRepository;

    public ViewingService(ViewingRepository viewingRepository) {
        this.viewingRepository = viewingRepository;
    }

    public Viewing getSeatsByViewing(int id) {
        Viewing viewing = new Viewing();
        try {
            ResultSet resultSet = viewingRepository.getSeatsByViewing(id);
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
