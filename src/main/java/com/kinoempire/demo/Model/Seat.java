package com.kinoempire.demo.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect
public class Seat {

    private int row;
    private int seat;

    public Seat() {
    }

    public Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
