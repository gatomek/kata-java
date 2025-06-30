package pl.gatomek.kata.java.jupiter;

public class Calculator {

    public int sum( int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int mult( int a, int b) {
        return a * b;
    }

    public int power(int a, int b) {
        return (int) Math.pow( a, b);
    }
}