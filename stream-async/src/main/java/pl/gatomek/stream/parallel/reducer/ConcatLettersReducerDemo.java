package pl.gatomek.stream.parallel.reducer;

import java.util.List;
import java.util.stream.Stream;

public class ConcatLettersReducerDemo {

    public static void main(String[] args) {
        System.out.println("Reducer Demo: Concatenating letters");

        String result1 = Stream.of( 'a', 'b', 'c', 'd', 'e', 'f').reduce( "", (a, c) -> a + c, (a, s) -> a + s);
        System.out.println( result1);

        String result2 = List.of( 'a', 'b', 'c', 'd', 'e', 'f').stream().reduce( "", (a, c) -> a + c, (a,s) -> a + s);
        System.out.println( result2);

        String result3 = List.of( 'a', 'b', 'c', 'd', 'e', 'f').parallelStream().reduce( "", (a,c) -> a + c, (a, s) -> a + s);
        System.out.println( result3);
    }
}
