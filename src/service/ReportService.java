package service;

import model.Booking;

import java.util.ArrayList;

public class ReportService {

    private BookingService bookingService;

    public ReportService(
            BookingService bookingService) {

        this.bookingService = bookingService;
    }

    public void displayBookingReport() {

        ArrayList<Booking> bookings =
                bookingService.getAllBookings();

        int totalBookings =
                bookings.size();

        int confirmedBookings = 0;

        int cancelledBookings = 0;

        int totalPassengers = 0;

        for (Booking booking : bookings) {

            if (booking.getStatus()
                    .equals("CONFIRMED")) {

                confirmedBookings++;

                totalPassengers +=
                        booking.getPassengers().size();

            } else if (booking.getStatus()
                    .equals("CANCELLED")) {

                cancelledBookings++;
            }
        }

        System.out.println(
                "\n========== BOOKING REPORT =========="
        );

        System.out.println(
                "Total Bookings: "
                        + totalBookings
        );

        System.out.println(
                "Confirmed Bookings: "
                        + confirmedBookings
        );

        System.out.println(
                "Cancelled Bookings: "
                        + cancelledBookings
        );

        System.out.println(
                "Total Active Passengers: "
                        + totalPassengers
        );

        System.out.println(
                "===================================="
        );
    }
}