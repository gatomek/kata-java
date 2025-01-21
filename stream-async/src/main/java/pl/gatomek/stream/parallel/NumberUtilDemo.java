package pl.gatomek.stream.parallel;

import java.util.stream.IntStream;

public class NumberUtilDemo {
    private static Boolean isPrime(Integer n) {
        IntStream intStream = IntStream.rangeClosed(2, (int) Math.sqrt(n));
        return intStream.parallel().noneMatch(d -> n % d == 0);
    }

    public static void main(String[] args) {
        System.out.println("Number Util Demo: Searching for Prime numbers");

        IntStream.rangeClosed(1, 1_000)
                .parallel()
                .filter(NumberUtilDemo::isPrime)
                .forEach(n -> System.out.print(n + ", "));
    }
}
