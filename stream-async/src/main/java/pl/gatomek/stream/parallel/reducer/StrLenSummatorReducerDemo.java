package pl.gatomek.stream.parallel.reducer;

import java.util.List;

public class StrLenSummatorReducerDemo {

    public static void main(String[] args) {
        System.out.println("Reducer demo: string len summator");

        List<String> list = List.of( "Java", "C++");

        // reduce( identity, accumulator, combiner )
        Integer total = list.stream().reduce( 0, (acc,b) -> acc + b.length(), (a, b)-> a + b);
        System.out.println( total);

        Integer total2 = list.stream().mapToInt( s -> s.length()).reduce( 0, (a,b) -> a + b);
        System.out.println( total2);

        Integer total3 = list.stream().mapToInt( s -> s.length()).sum();
        System.out.println( total3);
    }
}
