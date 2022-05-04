package ru.shelest.mario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class Mario {

    public static void main(String[] args) {
        try (final var reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("height: ");

            final var h = Integer.parseInt(reader.readLine());

            IntStream.range(2, 2 + h).forEach(i -> {
                IntStream.range(0, h + 1 - i)
                        .forEach(j -> System.out.print(" "));

                IntStream.range(0, i)
                        .forEach(j -> System.out.print("#"));

                System.out.println();
            });
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } catch (NumberFormatException exception) {
            System.err.println("Not a number!");
        }
    }
}
