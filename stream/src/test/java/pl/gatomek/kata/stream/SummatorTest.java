package pl.gatomek.kata.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummatorTest {

    private final List<Integer> empty = Collections.emptyList();
    private final List<Integer> values = Arrays.asList(1,2,3,4);

    @Test
    void givenSumByReducingWithLambda_whenEmptyTest() {
        int sum = new Summator().sumByReducingWithLambda(empty);
        assertEquals(0, sum);
    }

    @Test
    void givenSumByReducingWithLambdaWithMethodReference_whenEmptyTest() {
        int sum = new Summator().sumByReducingWithMethodReference(empty);
        assertEquals(0, sum);
    }

    @Test
    void givenSumByMappingToInt_whenEmptyTest() {
        int sum = new Summator().sumByMappingToInt(empty);
        assertEquals(0, sum);
    }

    @Test
    void givenSumByReducingWithLambda_whenNotEmptyTest() {
        int sum = new Summator().sumByReducingWithLambda(values);
        assertEquals(10, sum);
    }

    @Test
    void givenSumByReducingWithLambdaWithMethodReference_whenNotEmptyTest() {
        int sum = new Summator().sumByReducingWithMethodReference(values);
        assertEquals(10, sum);
    }

    @Test
    void givenSumByMappingToInt_whenNotEmptyTest() {
        int sum = new Summator().sumByMappingToInt(values);
        assertEquals(10, sum);
    }
}