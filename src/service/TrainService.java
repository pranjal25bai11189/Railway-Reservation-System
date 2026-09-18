package service;

import model.Train;

import java.util.ArrayList;
import java.util.Scanner;

import util.InputValidator;

public class TrainService {

    private ArrayList<Train> trains;

    public TrainService() {

        trains = new ArrayList<>();

        addTrain(new Train(
                12951,
                "Mumbai Rajdhani",
                "Mumbai",
                "Delhi",
                5
        ));

        addTrain(new Train(
                12952,
                "Delhi Rajdhani",
                "Delhi",
                "Mumbai",
                5
        ));

        addTrain(new Train(
                12002,
                "Shatabdi Express",
                "Delhi",
                "Bhopal",
                5
        ));

        addTrain(new Train(
                12155,
                "Bhopal Express",
                "Bhopal",
                "Delhi",
                5
        ));
    }

    public void addTrain(Train train) {

        trains.add(train);
    }

    public boolean trainExists(int trainNumber) {

        for (Train train : trains) {

            if (train.getTrainNumber()
                    == trainNumber) {

                return true;
            }
        }

        return false;
    }

    public boolean addNewTrain(
            int trainNumber,
            String trainName,
            String source,
            String destination,
            int totalSeats) {

        if (trainExists(trainNumber)) {
            return false;
        }

        Train train = new Train(
                trainNumber,
                trainName,
                source,
                destination,
                totalSeats
        );

        trains.add(train);

        return true;
    }

    public ArrayList<Train> searchTrains(
            String source,
            String destination) {

        ArrayList<Train> matchingTrains =
                new ArrayList<>();

        for (Train train : trains) {

            if (train.getSource()
                    .equalsIgnoreCase(source)
                    &&
                train.getDestination()
                    .equalsIgnoreCase(destination)) {

                matchingTrains.add(train);
            }
        }

        return matchingTrains;
    }

    public Train selectTrain(
            Scanner scanner,
            ArrayList<Train> matchingTrains) {

        if (matchingTrains.isEmpty()) {

            return null;
        }

        displayTrains(matchingTrains);

        int trainNumber =
                InputValidator.readPositiveInt(
                        scanner,
                        "\nEnter train number: "
                );

        for (Train train : matchingTrains) {

            if (train.getTrainNumber()
                    == trainNumber) {

                return train;
            }
        }

        System.out.println(
                "Invalid train number."
        );

        return null;
    }

    public void displayTrains(
            ArrayList<Train> matchingTrains) {

        if (matchingTrains.isEmpty()) {

            System.out.println(
                    "No trains found."
            );

            return;
        }

        System.out.println(
                "\n===== AVAILABLE TRAINS ====="
        );

        for (Train train :
                matchingTrains) {

            System.out.println(
                    "\nTrain Number: "
                            + train.getTrainNumber()
            );

            System.out.println(
                    "Train Name: "
                            + train.getTrainName()
            );

            System.out.println(
                    "Route: "
                            + train.getSource()
                            + " -> "
                            + train.getDestination()
            );

            System.out.println(
                    "Total Seats: "
                            + train.getTotalSeats()
            );

            System.out.println(
                    "Available Seats: "
                            + train.getAvailableSeats()
            );
        }
    }

    public void displayAllTrains() {

        System.out.println(
                "\n===== ALL TRAINS ====="
        );

        for (Train train : trains) {

            System.out.println(
                    "\nTrain Number: "
                            + train.getTrainNumber()
            );

            System.out.println(
                    "Train Name: "
                            + train.getTrainName()
            );

            System.out.println(
                    "Route: "
                            + train.getSource()
                            + " -> "
                            + train.getDestination()
            );

            System.out.println(
                    "Available Seats: "
                            + train.getAvailableSeats()
                            + "/"
                            + train.getTotalSeats()
            );
        }
    }
}