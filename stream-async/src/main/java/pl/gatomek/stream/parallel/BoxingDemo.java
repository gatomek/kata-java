package pl.gatomek.stream.parallel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingDemo {

    private static Boolean isEven(Integer n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println("Boxing Demo");

        {
            IntStream range = IntStream.rangeClosed(1, 10);
            List<Integer> result = range.parallel().filter(BoxingDemo::isEven).boxed().collect(Collectors.toList());
            result.forEach(System.out::println);
        }

        {
            IntStream range = IntStream.rangeClosed(1, 10);
            List<Integer> result = range.parallel().filter(BoxingDemo::isEven).boxed().toList();
            result.forEach(System.out::println);
        }
    }
}
