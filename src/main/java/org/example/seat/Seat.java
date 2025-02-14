package org.example.seat;

public class Seat {
    private String id;
    private int row;
    private int column;
    private SeatStatus seatStatus;
    private SeatType seatType;
    private double price;

    public Seat(String id, int row, int column, SeatStatus seatStatus, SeatType seatType, double price) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.seatStatus = seatStatus;
        this.seatType = seatType;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public double getPrice() {
        return price;
    }
}
