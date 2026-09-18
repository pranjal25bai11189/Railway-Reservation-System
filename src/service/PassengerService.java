package service;

import model.Passenger;
import exception.InvalidPassengerException;
import util.InputValidator;

import java.util.Scanner;

public class PassengerService {

    private int nextPassengerId;

    public PassengerService() {
        nextPassengerId = 101;
    }

    public Passenger createPassenger(Scanner scanner) {

        String name =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter passenger name: "
                );

        int age =
                InputValidator.readPositiveInt(
                        scanner,
                        "Enter passenger age: "
                );

        String gender =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter passenger gender: "
                );

        try {

            Passenger passenger =
                    new Passenger(
                            nextPassengerId,
                            name,
                            age,
                            gender
                    );

            nextPassengerId++;

            return passenger;

        } catch (InvalidPassengerException e) {

            System.out.println(
                    "\nInvalid Passenger: "
                            + e.getMessage()
            );

            return null;
        }
    }
}