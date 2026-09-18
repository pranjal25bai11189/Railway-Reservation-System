import model.Train;
import model.Passenger;
import model.Booking;

import service.TrainService;
import service.BookingService;
import service.AdminService;
import service.PassengerService;
import service.CancellationService;
import service.ReportService;

import util.InputValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TrainService trainService =
                new TrainService();

        BookingService bookingService =
                new BookingService();

        PassengerService passengerService =
                new PassengerService();

        CancellationService cancellationService =
                new CancellationService(
                        bookingService
                );

        ReportService reportService =
                new ReportService(
                        bookingService
                );

        AdminService adminService =
                new AdminService(
                        trainService,
                        reportService
                );

        DateTimeFormatter dateFormatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy"
                );

        boolean running = true;

        System.out.println(
                "===================================="
        );

        System.out.println(
                "     RAILWAY RESERVATION SYSTEM"
        );

        System.out.println(
                "===================================="
        );

        while (running) {

            System.out.println(
                    "\n========== MAIN MENU =========="
            );

            System.out.println("1. Search Train");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View All Bookings");
            System.out.println("5. Search Booking by PNR");
            System.out.println("6. View Waiting List");
            System.out.println("7. Admin Menu");
            System.out.println("8. Exit");

            System.out.println(
                    "==============================="
            );

            int choice =
                    InputValidator.readInt(
                            scanner,
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:

                    String source =
                            InputValidator.readNonEmptyString(
                                    scanner,
                                    "\nEnter source station: "
                            );

                    String destination =
                            InputValidator.readNonEmptyString(
                                    scanner,
                                    "Enter destination station: "
                            );

                    ArrayList<Train> trains =
                            trainService.searchTrains(
                                    source,
                                    destination
                            );

                    trainService.displayTrains(
                            trains
                    );

                    break;

                case 2:

                    source =
                            InputValidator.readNonEmptyString(
                                    scanner,
                                    "\nEnter source station: "
                            );

                    destination =
                            InputValidator.readNonEmptyString(
                                    scanner,
                                    "Enter destination station: "
                            );

                    ArrayList<Train> matchingTrains =
                            trainService.searchTrains(
                                    source,
                                    destination
                            );

                    if (matchingTrains.isEmpty()) {

                        trainService.displayTrains(
                                matchingTrains
                        );

                        break;
                    }

                    Train selectedTrain =
                            trainService.selectTrain(
                                    scanner,
                                    matchingTrains
                            );

                    if (selectedTrain == null) {
                        break;
                    }

                    LocalDate journeyDate = null;

                    while (journeyDate == null) {

                        String dateInput =
                                InputValidator
                                        .readNonEmptyString(
                                                scanner,
                                                "Enter journey date "
                                                + "(dd-MM-yyyy): "
                                        );

                        try {

                            journeyDate =
                                    LocalDate.parse(
                                            dateInput,
                                            dateFormatter
                                    );

                            if (journeyDate.isBefore(
                                    LocalDate.now())) {

                                System.out.println(
                                        "Journey date cannot "
                                        + "be in the past."
                                );

                                journeyDate = null;
                            }

                        } catch (
                                DateTimeParseException e) {

                            System.out.println(
                                    "Invalid date format. "
                                    + "Use dd-MM-yyyy."
                            );
                        }
                    }

                    int passengerCount =
                            InputValidator.readPositiveInt(
                                    scanner,
                                    "Enter number of passengers: "
                            );

                    ArrayList<Passenger> passengers =
                            new ArrayList<>();

                    boolean passengerDataValid =
                            true;

                    for (int i = 0;
                         i < passengerCount;
                         i++) {

                        System.out.println(
                                "\n--- Passenger "
                                + (i + 1)
                                + " ---"
                        );

                        Passenger passenger =
                                passengerService
                                        .createPassenger(
                                                scanner
                                        );

                        if (passenger == null) {

                            passengerDataValid =
                                    false;

                            break;
                        }

                        passengers.add(
                                passenger
                        );
                    }

                    if (passengerDataValid) {

                        Booking booking =
                                bookingService.bookTicket(
                                        selectedTrain,
                                        passengers,
                                        journeyDate
                                );

                        if (booking != null) {

                            System.out.println(
                                    "\n===== BOOKING "
                                    + "SUCCESSFUL ====="
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
                                    "Train: "
                                            + booking.getTrain()
                                                    .getTrainName()
                            );

                            System.out.println(
                                    "Journey Date: "
                                            + booking
                                                    .getJourneyDate()
                                                    .format(
                                                            dateFormatter
                                                    )
                            );

                            System.out.println(
                                    "Passengers: "
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

                    break;

                case 3:

                    int bookingId =
                            InputValidator.readPositiveInt(
                                    scanner,
                                    "\nEnter booking ID to cancel: "
                            );

                    boolean cancelled =
                            cancellationService.cancelTicket(
                                    bookingId
                            );

                    if (cancelled) {

                        System.out.println(
                                "Ticket cancelled successfully."
                        );

                    } else {

                        System.out.println(
                                "Booking ID not found."
                        );
                    }

                    break;

                case 4:

                    bookingService.displayAllBookings();

                    break;

                case 5:

                    String pnr =
                            InputValidator.readNonEmptyString(
                                    scanner,
                                    "\nEnter PNR: "
                            );

                    Booking booking =
                            bookingService.searchByPNR(
                                    pnr
                            );

                    bookingService.displayBooking(
                            booking
                    );

                    break;

                case 6:

                    bookingService.displayWaitingList();

                    break;

                case 7:

                    adminService.showAdminMenu(
                            scanner
                    );

                    break;

                case 8:

                    running = false;

                    System.out.println(
                            "\nThank you for using "
                            + "Railway Reservation System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }
}