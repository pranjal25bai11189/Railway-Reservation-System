package model;

import java.util.ArrayList;

public class Train {

    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;

    private int totalSeats;
    private int availableSeats;
    private int nextSeatNumber;

    private ArrayList<Integer> cancelledSeats;

    public Train(int trainNumber, String trainName, String source,
                 String destination, int totalSeats) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.nextSeatNumber = 1;

        cancelledSeats = new ArrayList<>();
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int allocateSeat() {

        if (availableSeats <= 0) {
            return -1;
        }

        int seatNumber;

        // Reuse a previously cancelled seat first
        if (!cancelledSeats.isEmpty()) {

            seatNumber = cancelledSeats.remove(0);

        } else {

            seatNumber = nextSeatNumber;
            nextSeatNumber++;
        }

        availableSeats--;

        return seatNumber;
    }

    public void cancelSeat(int seatNumber) {

        if (seatNumber > 0 && seatNumber < nextSeatNumber) {

            if (!cancelledSeats.contains(seatNumber)) {

                cancelledSeats.add(seatNumber);
                availableSeats++;
            }
        }
    }
}