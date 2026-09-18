package service;

import model.Train;
import model.Passenger;
import model.Booking;
import util.PNRGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BookingService {

    private ArrayList<Booking> bookings;

    private HashMap<Train, Queue<Passenger>> waitingLists;

    private int nextBookingId;

    private static final int MAX_PASSENGERS_PER_BOOKING = 6;

    public BookingService() {

        bookings = new ArrayList<>();

        waitingLists =
                new HashMap<>();

        nextBookingId = 5001;
    }

    public Booking bookTicket(
            Train train,
            ArrayList<Passenger> passengers,
            LocalDate journeyDate) {

        if (train == null) {

            System.out.println(
                    "Invalid train."
            );

            return null;
        }

        if (passengers == null
                || passengers.isEmpty()) {

            System.out.println(
                    "At least one passenger is required."
            );

            return null;
        }

        if (passengers.size()
                > MAX_PASSENGERS_PER_BOOKING) {

            System.out.println(
                    "Maximum "
                    + MAX_PASSENGERS_PER_BOOKING
                    + " passengers are allowed "
                    + "in one booking."
            );

            return null;
        }

        if (journeyDate == null
                || journeyDate.isBefore(LocalDate.now())) {

            System.out.println(
                    "Invalid journey date."
            );

            return null;
        }

        if (passengers.size()
                > train.getAvailableSeats()) {

            System.out.println(
                    "Not enough seats available."
            );

            Queue<Passenger> queue =
                    waitingLists.get(train);

            if (queue == null) {

                queue = new LinkedList<>();

                waitingLists.put(
                        train,
                        queue
                );
            }

            for (Passenger passenger :
                    passengers) {

                queue.add(passenger);

                System.out.println(
                        passenger.getName()
                                + " added to waiting list."
                );
            }

            return null;
        }

        return createBooking(
                train,
                passengers,
                journeyDate
        );
    }

    private Booking createBooking(
            Train train,
            ArrayList<Passenger> passengers,
            LocalDate journeyDate) {

        ArrayList<Integer> seatNumbers =
                new ArrayList<>();

        for (int i = 0;
             i < passengers.size();
             i++) {

            int seatNumber =
                    train.allocateSeat();

            if (seatNumber == -1) {

                return null;
            }

            seatNumbers.add(
                    seatNumber
            );
        }

        String pnr =
                PNRGenerator.generatePNR();

        Booking booking =
                new Booking(
                        nextBookingId,
                        pnr,
                        passengers,
                        train,
                        seatNumbers,
                        journeyDate
                );

        bookings.add(booking);

        nextBookingId++;

        return booking;
    }

    public Booking findBookingById(
            int bookingId) {

        for (Booking booking :
                bookings) {

            if (booking.getBookingId()
                    == bookingId) {

                return booking;
            }
        }

        return null;
    }

    public Booking searchByPNR(
            String pnr) {

        for (Booking booking :
                bookings) {

            if (booking.getPnr()
                    .equalsIgnoreCase(pnr)) {

                return booking;
            }
        }

        return null;
    }

    public void processWaitingListAfterCancellation(
            Train train) {

        Queue<Passenger> queue =
                waitingLists.get(train);

        if (queue == null) {
            return;
        }

        while (!queue.isEmpty()
                && train.getAvailableSeats() > 0) {

            Passenger passenger =
                    queue.poll();

            ArrayList<Passenger> passengers =
                    new ArrayList<>();

            passengers.add(passenger);

            Booking booking =
                    createBooking(
                            train,
                            passengers,
                            LocalDate.now()
                    );

            if (booking != null) {

                System.out.println(
                        "\nWaiting list passenger "
                                + passenger.getName()
                                + " has been allocated "
                                + "a seat."
                );

                System.out.println(
                        "New Booking ID: "
                                + booking.getBookingId()
                );

                System.out.println(
                        "New PNR: "
                                + booking.getPnr()
                );

                System.out.println(
                        "Seat Number: "
                                + booking
                                        .getSeatNumbers()
                                        .get(0)
                );
            }
        }

        if (queue.isEmpty()) {

            waitingLists.remove(train);
        }
    }

    public void displayBooking(
            Booking booking) {

        if (booking == null) {

            System.out.println(
                    "Booking not found."
            );

            return;
        }

        System.out.println(
                "\n===== BOOKING DETAILS ====="
        );

        System.out.println(
                "Booking ID: "
                        + booking.getBookingId()
        );

        System.out.println(
                "PNR: "
                        + booking.getPnr()
        );

        System.out.println(
                "Status: "
                        + booking.getStatus()
        );

        System.out.println(
                "Train Number: "
                        + booking.getTrain()
                                .getTrainNumber()
        );

        System.out.println(
                "Train: "
                        + booking.getTrain()
                                .getTrainName()
        );

        System.out.println(
                "Route: "
                        + booking.getTrain()
                                .getSource()
                        + " -> "
                        + booking.getTrain()
                                .getDestination()
        );

        System.out.println(
                "Journey Date: "
                        + booking.getJourneyDate()
        );

        System.out.println(
                "\nPassengers:"
        );

        ArrayList<Passenger> passengers =
                booking.getPassengers();

        ArrayList<Integer> seats =
                booking.getSeatNumbers();

        for (int i = 0;
             i < passengers.size();
             i++) {

            Passenger passenger =
                    passengers.get(i);

            System.out.println(
                    "\nPassenger "
                            + (i + 1)
            );

            System.out.println(
                    "Name: "
                            + passenger.getName()
            );

            System.out.println(
                    "Age: "
                            + passenger.getAge()
            );

            System.out.println(
                    "Gender: "
                            + passenger.getGender()
            );

            System.out.println(
                    "Seat Number: "
                            + seats.get(i)
            );
        }
    }

    public void displayAllBookings() {

        if (bookings.isEmpty()) {

            System.out.println(
                    "No bookings found."
            );

            return;
        }

        System.out.println(
                "\n===== ALL BOOKINGS ====="
        );

        for (Booking booking :
                bookings) {

            System.out.println(
                    "\nBooking ID: "
                            + booking.getBookingId()
            );

            System.out.println(
                    "PNR: "
                            + booking.getPnr()
            );

            System.out.println(
                    "Status: "
                            + booking.getStatus()
            );

            System.out.println(
                    "Train: "
                            + booking.getTrain()
                                    .getTrainName()
            );

            System.out.println(
                    "Journey Date: "
                            + booking.getJourneyDate()
            );

            System.out.println(
                    "Number of Passengers: "
                            + booking
                                    .getPassengers()
                                    .size()
            );

            System.out.println(
                    "Seats: "
                            + booking
                                    .getSeatNumbers()
            );
        }
    }

    public void displayWaitingList() {

        if (waitingLists.isEmpty()) {

            System.out.println(
                    "Waiting lists are empty."
            );

            return;
        }

        System.out.println(
                "\n===== WAITING LISTS ====="
        );

        for (Train train :
                waitingLists.keySet()) {

            Queue<Passenger> queue =
                    waitingLists.get(train);

            System.out.println(
                    "\nTrain: "
                            + train.getTrainName()
            );

            int position = 1;

            for (Passenger passenger :
                    queue) {

                System.out.println(
                        position
                                + ". "
                                + passenger.getName()
                );

                position++;
            }
        }
    }

    public ArrayList<Booking> getAllBookings() {

        return bookings;
    }

    public int getBookingCount() {

        return bookings.size();
    }
}