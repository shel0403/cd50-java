package ru.shelest.sigma;

public class Main {

    public static void main(String[] args) {
        System.out.println(sigma(5));
    }

    private static int sigma(int n) {
        return n < 1 ? 0 : n + sigma(n - 1);
    }
}
