package ru.shelest;

import java.util.function.Supplier;

public final class Checker {

    private Checker() {
    }

    public static void require(
            boolean statement,
            final Supplier<RuntimeException> exceptionSupplier
    ) {
        if (exceptionSupplier == null) {
            throw new IllegalArgumentException("Argument is null.");
        }

        if (!statement) {
            throw exceptionSupplier.get();
        }
    }
}
