package org.example;

import org.example.seat.Seat;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Show {


    private String id;
    private Movie movie;
    private Theatre theatre;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private HashMap<String, Seat> seats;

    public Show(String id, Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime, HashMap<String, Seat> seats) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, Seat> getSeats() {
        return seats;
    }


}
