package org.example.booking;
import org.example.*;
import org.example.seat.Seat;

import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<Seat> seats;
    private double totalPrice;
    private BookingStatus bookingStatus;

    public Booking(String id, User user, Show show, List<Seat> seats, double totalPrice, BookingStatus bookingStatus) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }



}
