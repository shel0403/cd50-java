package ru.shelest.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import static ru.shelest.Checker.require;

public class Dictionary {

    private final Set<String> dictionary = new HashSet<>();

    public void load(final String dictionarySourcePath) throws IOException {
        require(
                dictionarySourcePath != null,
                () -> new IllegalArgumentException("Argument is null")
        );

        final var source = Paths.get(dictionarySourcePath);

        try (final var sourceContent = Files.lines(source)) {
            sourceContent.forEach(this.dictionary::add);
        }
    }

    public boolean check(final String word) {
        require(
                word != null,
                () -> new IllegalArgumentException("Argument is null.")
        );

        return this.dictionary.contains(word);
    }
}
