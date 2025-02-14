package org.example;

import org.example.booking.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MovieTicketBookingSystem {
    private MovieTicketBookingSystem instance;
    private List<Movie> movies;
    private List<Theatre> theatres;
    //because we need user to select
    private Map<String, Show> shows;
    //check why is it HashMap
    private Map<String, Booking> bookings;

    public MovieTicketBookingSystem() {
        movies = new ArrayList<>();
        theatres = new ArrayList<>();
        shows = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
    }

    public synchronized MovieTicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new MovieTicketBookingSystem();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addTheatres(Theatre theatre) {
        theatres.add(theatre);
    }

    public void addShows(Show show) {
        shows.put(show.getId(), show);
    }

    public void






}
