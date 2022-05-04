package ru.shelest.initials;

import java.util.Arrays;
import java.util.Scanner;

public class Initials {

    public static void main(String[] args) {
        try (final var scanner = new Scanner(System.in)) {
            final var name = scanner.nextLine();

            Arrays.stream(name.trim().split("\\s+"))
                    .map(s -> s.charAt(0))
                    .map(Character::toUpperCase)
                    .forEach(System.out::print);

            System.out.println();
        }
    }
}
