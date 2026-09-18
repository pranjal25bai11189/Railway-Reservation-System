package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {

    private int bookingId;
    private String pnr;
    private ArrayList<Passenger> passengers;
    private Train train;
    private ArrayList<Integer> seatNumbers;
    private LocalDate journeyDate;
    private String status;

    public Booking(
            int bookingId,
            String pnr,
            ArrayList<Passenger> passengers,
            Train train,
            ArrayList<Integer> seatNumbers,
            LocalDate journeyDate) {

        this.bookingId = bookingId;
        this.pnr = pnr;
        this.passengers = passengers;
        this.train = train;
        this.seatNumbers = seatNumbers;
        this.journeyDate = journeyDate;
        this.status = "CONFIRMED";
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getPnr() {
        return pnr;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Train getTrain() {
        return train;
    }

    public ArrayList<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public String getStatus() {
        return status;
    }

    public void cancelBooking() {
        status = "CANCELLED";
    }
}