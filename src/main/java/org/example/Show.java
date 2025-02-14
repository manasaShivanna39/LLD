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
    private HashMap<String, Seat> seatMap;

    public Show(String id, Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime, HashMap<String, Seat> seatMap) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seatMap = seatMap;
    }

    public String getId() {
        return id;
    }


}
