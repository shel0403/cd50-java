package ru.shelest.recovery;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;

public class Recovery {

    private static final String SOURCE_DIRECTORY_PATH = "/home/shel0403/IdeaProjects/cs50/src/main/resources/";
    private static final int BUF_SIZE = 512;

    public static void main(String[] args) {
        try {
            final var sourceName = String.format("%s%s", SOURCE_DIRECTORY_PATH, "card.raw");
            final var source = Paths.get(sourceName);

            require(
                    Files.exists(source),
                    () -> new IllegalArgumentException(String.format("No such file: %s!", sourceName))
            );

            try (final InputStream fileReader = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                OutputStream fileWriter = null;
                final var buffer = new byte[BUF_SIZE];
                var fileId = 0;

                while (fileReader.read(buffer) != 0) {
                    if (buffer[0] == (byte) 0xFF && buffer[1] == (byte) 0xD8 && buffer[2] == (byte) 0xFF) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception exception) {
                                throw new IllegalStateException("Couldn't close file!", exception);
                            }
                        }

                        final var targetName = String.format("%s%d.jpg", SOURCE_DIRECTORY_PATH, ++fileId);
                        final var target = Paths.get(targetName);

                        fileWriter = new BufferedOutputStream(new FileOutputStream(target.toFile()));
                    }

                    if (fileWriter != null) {
                        fileWriter.write(buffer);
                    }
                }

                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception exception) {
                        throw new IllegalStateException("Couldn't close file!", exception);
                    }
                }
            } catch (FileNotFoundException exception) {
                System.err.printf("No such file: %s!", sourceName);
            } catch (IOException exception) {
                System.err.printf("Something went wrong: %s%n", exception.getMessage());
            } catch (IllegalStateException exception) {
                System.err.println(exception.getMessage());
            }
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void require(boolean condition, Supplier<RuntimeException> exceptionSupplier) {
        if (!condition) {
            throw exceptionSupplier.get();
        }
    }
}
