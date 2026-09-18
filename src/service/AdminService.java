package service;

import util.InputValidator;

import java.util.Scanner;

public class AdminService {

    private TrainService trainService;
    private ReportService reportService;

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "1234";

    public AdminService(
            TrainService trainService,
            ReportService reportService) {

        this.trainService = trainService;
        this.reportService = reportService;
    }

    public void showAdminMenu(Scanner scanner) {

        if (!login(scanner)) {

            System.out.println(
                    "\nAccess denied."
            );

            return;
        }

        boolean adminRunning = true;

        while (adminRunning) {

            System.out.println(
                    "\n========== ADMIN MENU =========="
            );

            System.out.println(
                    "1. Add New Train"
            );

            System.out.println(
                    "2. View All Trains"
            );

            System.out.println(
                    "3. View Booking Report"
            );

            System.out.println(
                    "4. Back to Main Menu"
            );

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

                    addTrain(scanner);

                    break;

                case 2:

                    trainService.displayAllTrains();

                    break;

                case 3:

                    reportService.displayBookingReport();

                    break;

                case 4:

                    adminRunning = false;

                    break;

                default:

                    System.out.println(
                            "Invalid admin choice."
                    );
            }
        }
    }

    private boolean login(Scanner scanner) {

        System.out.println(
                "\n========== ADMIN LOGIN =========="
        );

        String username =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter username: "
                );

        String password =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter password: "
                );

        if (username.equals(ADMIN_USERNAME)
                && password.equals(ADMIN_PASSWORD)) {

            System.out.println(
                    "\nAdmin login successful."
            );

            return true;
        }

        System.out.println(
                "\nInvalid username or password."
        );

        return false;
    }

    private void addTrain(Scanner scanner) {

        int trainNumber =
                InputValidator.readPositiveInt(
                        scanner,
                        "\nEnter train number: "
                );

        String trainName =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter train name: "
                );

        String source =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter source: "
                );

        String destination =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter destination: "
                );

        int totalSeats =
                InputValidator.readPositiveInt(
                        scanner,
                        "Enter total seats: "
                );

        boolean added =
                trainService.addNewTrain(
                        trainNumber,
                        trainName,
                        source,
                        destination,
                        totalSeats
                );

        if (added) {

            System.out.println(
                    "Train added successfully."
            );

        } else {

            System.out.println(
                    "Train number already exists."
            );
        }
    }
}