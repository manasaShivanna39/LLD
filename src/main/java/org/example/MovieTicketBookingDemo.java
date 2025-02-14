package org.example;
import org.example.booking.Booking;
import org.example.seat.Seat;
import org.example.seat.SeatStatus;
import org.example.seat.SeatType;

import java.time.LocalDateTime;
import java.util.*;

public class MovieTicketBookingDemo {
    public static void main(String[] args){

        MovieTicketBookingSystem bookingSystem = MovieTicketBookingSystem.getInstance();

        Movie movie1 = new Movie("M1", "Movie 1", "Description 1", 120);
        Movie movie2 = new Movie("M2", "Movie 2", "Description 2", 135);
        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);

        // Add theaters
        Theater theater1 = new Theater("T1", "Theater 1", "Location 1", new ArrayList<>());
        Theater theater2 = new Theater("T2", "Theater 2", "Location 2", new ArrayList<>());
        bookingSystem.addTheater(theater1);
        bookingSystem.addTheater(theater2);

        // Add shows
        Show show1 = new Show("S1", movie1, theater1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie1.getDurationInMinutes()), createSeats(10, 10));
        Show show2 = new Show("S2", movie2, theater2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie2.getDurationInMinutes()), createSeats(8, 8));
        bookingSystem.addShow(show1);
        bookingSystem.addShow(show2);

        // Book tickets
        User user = new User("U1", "John Doe", "john@example.com");
        List<Seat> selectedSeats = Arrays.asList(show1.getSeats().get("1-5"), show1.getSeats().get("1-6"));
        Booking booking = bookingSystem.bookTicket(user,show1,selectedSeats);

        if(booking!=null){
            System.out.println("Booking successful. Booking ID: " + booking.getId());
            bookingSystem.confirmBooking(booking);
        }else{
            System.out.println("Booking failed. Seats not available.");
        }

    }

    private static HashMap<String, Seat> createSeats(int row, int col) {
        HashMap<String,Seat> seatMap = new HashMap<>();
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                String seatId = i+"-"+j;
                SeatType type = row<=2?SeatType.PREMIUM:SeatType.NORMAL;
                double price = type==SeatType.PREMIUM?150.0:100.0;
                Seat seat = new Seat(seatId,row,col, SeatStatus.AVAILABLE,type,price);
                seatMap.put(seatId,seat);
            }
        }
        return seatMap;
    }
}
