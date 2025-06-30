package pl.gatomek.kata.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Summator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Summator.class);

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        Summator summator = new Summator();

        LOGGER.info("sum by reducing: {}", summator.sumByReducingWithLambda(values));
        LOGGER.info("sum by reducing: {}", summator.sumByReducingWithMethodReference(values));
        LOGGER.info("sum by mapping: {}", summator.sumByMappingToInt(values));
    }

    public int sumByReducingWithLambda(List<Integer> values) {
        return values.stream().reduce(0, (acc, i) -> acc + i);
    }

    public int sumByReducingWithMethodReference(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }

    public int sumByMappingToInt(List<Integer> values) {
        return values.stream().mapToInt(i -> i).sum();
    }
}