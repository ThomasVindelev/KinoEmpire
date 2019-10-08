package com.kinoempire.demo.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Viewing {

    private List<Seat> seating = new ArrayList<>();
    private Movie movie;
    private Theater theater;
    private java.sql.Date date;


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

    public Date getDate() {
        return date;
    }

    public void setSeating(List<Seat> seating) {
        this.seating = seating;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
