package pl.gatomek.stream.parallel.reducer;

import java.util.stream.IntStream;

public class SummatorReducerDemo {

    public static void main(String[] args) {
        System.out.println("Reducer Demo: Simple Integer Summator");

        Integer result1 = IntStream.rangeClosed(1, 4).reduce(0, (a, b) -> a + b);
        System.out.println(result1);

        Integer result2 = IntStream.rangeClosed(1, 4).parallel().reduce(0, (a, b) -> a + b);
        System.out.println(result2);
    }
}
