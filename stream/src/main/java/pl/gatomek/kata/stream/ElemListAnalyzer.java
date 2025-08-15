package pl.gatomek.kata.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Elem(String key, Integer value) {
    public static Elem of(String key, Integer value) {
        return new Elem(key, value);
    }
}

class ElemListAnalyzer {
    private static final List<Elem> list = List.of(
            Elem.of("C", 1),
            Elem.of("A", 12),
            Elem.of("B", 2),
            Elem.of("B", 2),
            Elem.of("A", 4)
    );

    public static void main(String[] args) {

        Map<String, Integer> sum0 = sumPerKeyByLambda(list);
        /**
         * "A" -> 16
         * "B" ->  4
         * "C" ->  1
         */

        Map<String, Integer> sum1 = sumPerKeyByFun(list);
        /**
         * "A" -> 16
         * "B" ->  4
         * "C" ->  1
         */

        Map<String, Integer> mins = minPerKey(list);
        /**
         * "A" -> 4
         * "B" -> 2
         * "C" -> 1
         */

        Map<String, Integer> maxs = maxPerKey(list);
        /**
         * "A" -> 12
         * "B" -> 2
         * "C" -> 1
         */
    }

    static Map<String, Integer> sumPerKeyByLambda(List<Elem> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Elem::key, Collectors.reducing(0, Elem::value, (a, b) -> a + b)));
    }

    static Map<String, Integer> sumPerKeyByFun(List<Elem> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Elem::key, Collectors.reducing(0, Elem::value, Integer::sum)));
    }

    static Map<String, Integer> minPerKey(List<Elem> list) {
        return list.stream()
                .collect(Collectors.toMap(Elem::key, Elem::value, Math::min));
    }

    static Map<String, Integer> maxPerKey(List<Elem> list) {
        return list.stream()
                .collect(Collectors.toMap(Elem::key, Elem::value, Math::max));
    }
}
