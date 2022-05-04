package ru.shelest.water;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final int WATER_CONSUMPTION_PER_MINUTE = 6;
    private static final int BOTTLES_IN_LITER = 2;

    public static void main(String[] args) {
        try (final var scanner = new Scanner(System.in)) {
            System.out.print("/waterminutes: ");

            int minutes = scanner.nextInt();

            if (minutes < 0) {
                throw new IllegalArgumentException("Illegal argument!");
            }

            System.out.printf("Bottles: %d\n", minutes * WATER_CONSUMPTION_PER_MINUTE * BOTTLES_IN_LITER);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        } catch (InputMismatchException exception) {
            System.err.println("Not a number!");
        }
    }
}
