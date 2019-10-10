package com.kinoempire.demo.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Viewing {

    private List<Seat> seating = new ArrayList<>();
    private Movie movie;
    private Theater theater;
    private int movieId;
    private int theaterId;
    private String date;

    public Viewing() {

    }

    public List<Seat> getSeating() {
        return seating;
    }

    public void setSeating(Seat seat) {
        seating.add(seat);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
    public void setSeating(List<Seat> seating) {
        this.seating = seating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
