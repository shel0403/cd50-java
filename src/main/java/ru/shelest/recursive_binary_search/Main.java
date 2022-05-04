package ru.shelest.recursive_binary_search;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        IntStream.range(0, 10)
                .forEach(i -> System.out.printf("%d -> %d\n", i, search(i, array)));
    }

    private static int search(int n, int[] array) {
        return search(n, array, 0, array.length - 1);
    }

    private static int search(int n, int[] array, int left, int right) {
        if (left > right) {
            return -1;
        }

        final var middle = left + (right - left) / 2;

        if (n < array[middle]) {
            return search(n, array, left, middle - 1);
        }

        if (n > array[middle]) {
            return search(n, array, middle + 1, right);
        }

        return middle;
    }
}
