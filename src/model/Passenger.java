package model;

import exception.InvalidPassengerException;

public class Passenger {

    private int passengerId;
    private String name;
    private int age;
    private String gender;

    public Passenger(int passengerId, String name, int age, String gender)
            throws InvalidPassengerException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPassengerException(
                    "Passenger name cannot be empty."
            );
        }

        if (age <= 0 || age > 120) {
            throw new InvalidPassengerException(
                    "Passenger age must be between 1 and 120."
            );
        }

        if (gender == null || gender.trim().isEmpty()) {
            throw new InvalidPassengerException(
                    "Gender cannot be empty."
            );
        }

        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}