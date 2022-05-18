package ru.shelest.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final var dictionary = new Dictionary();

        try {
            dictionary.load("src/main/resources/dictionaries/large");
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        final var book = Paths.get("src/main/resources/dictionaries/tolstoy.txt");

        try (final var bookLines = Files.lines(book)) {
            bookLines.map(line -> line.trim().split("\\s+"))
                    .flatMap(Arrays::stream)
                    .map(w -> w.replaceAll("\\W", ""))
                    .map(String::toLowerCase)
                    .filter(w -> !dictionary.check(w))
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
