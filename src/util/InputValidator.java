package util;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();
                scanner.nextLine();

                return value;

            } else {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.nextLine();
            }
        }
    }

    public static int readPositiveInt(
            Scanner scanner,
            String message) {

        while (true) {

            int value =
                    readInt(scanner, message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than 0."
            );
        }
    }

    public static String readNonEmptyString(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String value =
                    scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}