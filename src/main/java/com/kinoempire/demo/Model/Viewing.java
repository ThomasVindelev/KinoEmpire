package com.kinoempire.demo.Model;

import java.util.List;

public class Viewing {

    private List<Seat> seating;

    public Viewing() {

    }

    public List<Seat> getSeating() {
        return seating;
    }

    public void setSeating(Seat seat) {
        seating.add(seat);
    }
}
