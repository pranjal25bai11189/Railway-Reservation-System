package service;

import model.Booking;
import model.Train;

import java.util.ArrayList;

public class CancellationService {

    private BookingService bookingService;

    public CancellationService(
            BookingService bookingService) {

        this.bookingService = bookingService;
    }

    public boolean cancelTicket(int bookingId) {

        Booking booking =
                bookingService.findBookingById(
                        bookingId
                );

        if (booking == null) {
            return false;
        }

        if (booking.getStatus()
                .equals("CANCELLED")) {

            System.out.println(
                    "This booking is already cancelled."
            );

            return false;
        }

        Train train =
                booking.getTrain();

        ArrayList<Integer> seatNumbers =
                booking.getSeatNumbers();

        for (int seatNumber : seatNumbers) {

            train.cancelSeat(
                    seatNumber
            );
        }

        booking.cancelBooking();

        bookingService.processWaitingListAfterCancellation(
                train
        );

        return true;
    }
}