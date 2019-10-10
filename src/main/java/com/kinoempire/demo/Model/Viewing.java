package com.kinoempire.demo.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Viewing {

    private int id;
    private List<Seat> seating = new ArrayList<>();
    private Movie movie;
    private Theater theater;
    private int mid;
    private int theaterId;
    private String date;

    public Viewing() {

    }

    public Viewing(List<Seat> seating, Movie movie, Theater theater, int mid, int theaterId, String date) {
        this.seating = seating;
        this.movie = movie;
        this.theater = theater;
        this.mid = mid;
        this.theaterId = theaterId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeating() {
        return seating;
    }

    public void addSeating(Seat seat) {
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


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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
