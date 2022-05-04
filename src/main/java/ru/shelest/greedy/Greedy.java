package ru.shelest.greedy;

import java.util.Scanner;

public class Greedy {

    public static void main(String[] args) {
        System.out.println("O hai! How much change is owed?");

        try (final var scanner = new Scanner(System.in)) {
            double greedy = 0.0;
            boolean success;

            do {
                success = true;
                final var input = scanner.nextLine();

                try {
                    greedy = Double.parseDouble(input);

                    if (Double.compare(greedy, 0.0) < 0) {
                        throw new IllegalArgumentException();
                    }
                } catch (NumberFormatException exception) {
                    success = false;

                    System.out.print("Retry: ");
                } catch (IllegalArgumentException exception) {
                    success = false;

                    System.out.println("How much change is owed?");
                }
            } while (!success);

            final var centSum = (int) (greedy * 100);

            var result = 0;
            var reminder = centSum;

            while (reminder - 25 >= 0) {
                reminder -= 25;
                result++;
            }

            while (reminder - 10 >= 0) {
                reminder -= 10;
                result++;
            }

            while (reminder - 5 >= 0) {
                reminder -= 5;
                result++;
            }

            while (reminder - 1 >= 0) {
                reminder--;
                result++;
            }

            System.out.println(result);
        }
    }
}
