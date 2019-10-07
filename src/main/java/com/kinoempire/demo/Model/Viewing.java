package com.kinoempire.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class Viewing {

    private List<Seat> seating = new ArrayList<>();

    public Viewing() {

    }

    public List<Seat> getSeating() {
        return seating;
    }

    public void setSeating(Seat seat) {
        seating.add(seat);
    }
}
