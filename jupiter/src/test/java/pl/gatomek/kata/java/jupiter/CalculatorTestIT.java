package pl.gatomek.kata.java.jupiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// to be treated as Integration Tests via maven failsafe plugin
class CalculatorTestIT {

    @Test
    void sumTests() {
        Calculator calc = new Calculator();
        int res = calc.sum( 1,2);
        assertEquals(3, res);
    }

    @Test
    void subtractTests() {
        Calculator calc = new Calculator();
        int res = calc.subtract( 1,2);
        assertEquals(-1, res);
    }

    @Test
    void multTests() {
        Calculator calc = new Calculator();
        int res = calc.mult( 3,2);
        assertEquals(6, res);
    }

    @Test
    void powerTests() {
        Calculator calc = new Calculator();
        int res = calc.power( 2,2);
        assertEquals(4, res);
    }
}