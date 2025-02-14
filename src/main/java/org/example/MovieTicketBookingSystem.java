package org.example;

import org.example.booking.Booking;
import org.example.booking.BookingStatus;
import org.example.seat.Seat;
import org.example.seat.SeatStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MovieTicketBookingSystem {
    private MovieTicketBookingSystem instance;
    private List<Movie> movies;
    private List<Theatre> theatres;
    //because we need user to select
    private Map<String, Show> shows;
    //check why is it HashMap
    private Map<String, Booking> bookings;
    private final String BOOKING_ID_PREFIX = "BKG";
    private AtomicLong Booking_counter = new AtomicLong();

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

    public synchronized Booking bookTicket(User user, Show show, List<Seat> selectedSeats){
        if(areTicketsAvailable(show,selectedSeats)){
            markTicketsBooked(show,selectedSeats);
            double totalPrice = calculatePrice(selectedSeats);
            String bookingId = createBookingId();
            Booking booking = new Booking(bookingId,user,show,selectedSeats,totalPrice, BookingStatus.PENDING);
            bookings.put(bookingId,booking);
            return booking;
        }
        return null;
    }




    private boolean areTicketsAvailable(Show show, List<Seat> selectedSeats) {
        for(Seat seat : selectedSeats){
            Seat showSeat  = show.getSeats().get(seat.getId());
            if(showSeat!=null && showSeat.getSeatStatus()!= SeatStatus.AVAILABLE){
                return false;
            }
        }
        return true;
    }

    private void markTicketsBooked(Show show, List<Seat> selectedSeats) {
        for(Seat seat : selectedSeats){
            Seat showSeat  = show.getSeats().get(seat.getId());
            showSeat.setSeatStatus(SeatStatus.BOOKED);
        }
    }

    private String createBookingId() {
        long counter = Booking_counter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return BOOKING_ID_PREFIX+counter+timestamp;
    }

    private double calculatePrice(List<Seat> selectedSeats) {
        return selectedSeats.stream().mapToDouble(Seat::getPrice).sum();
    }




}
