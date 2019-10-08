package com.kinoempire.demo.Service;

import com.kinoempire.demo.Model.*;
import com.kinoempire.demo.Repository.ViewingRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public Viewing getViewingById(int id) {
        Viewing viewing = new Viewing();
        Movie movie = new Movie();
        Genre genre = new Genre();
        Theater theater = new Theater();
        Seat seat = new Seat();
        try {
            ResultSet resultSet = viewingRepository.getViewingById(id);
            while (resultSet.next()) {
                movie.setTitle(resultSet.getString("title"));
                movie.setDescription(resultSet.getString("description"));
                movie.setLength(resultSet.getInt("length"));
                movie.setAge_limit(resultSet.getInt("age_limit"));
                genre.setName(resultSet.getString("genre"));
                theater.setRows(resultSet.getInt("rows"));
                theater.setSeats(resultSet.getInt("seats"));
                viewing.setDate(resultSet.getDate("time"));
                seat.setRow(resultSet.getInt("seating.row"));
                seat.setSeat(resultSet.getInt("seating.seat"));
                movie.setGenre(genre);
                viewing.setMovie(movie);
                viewing.setTheater(theater);
                viewing.setSeating(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewing;
    }

    public void reserveSeats(Seat[] seats, int viewingId) {
        for (Seat seat : seats) {
            try {
                viewingRepository.reserveSeats(seat, viewingId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
