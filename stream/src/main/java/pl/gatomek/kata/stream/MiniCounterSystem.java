package pl.gatomek.kata.stream;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <b>Links:</b>
 * @see <a href="https://www.baeldung.com/java-enum-map">A Guide to EnumMap</a>
*/

enum MeasurementType {
    P,
    Q
}

record Aggregate(LocalDateTime measurementTime, BigDecimal value) {
    public static Aggregate of( LocalDateTime measurementTime, BigDecimal value) {
        return new Aggregate( measurementTime, value);
    }
}

class MiniCounterSystem {
    private static final LocalDateTime dt_2025_08_15__15_15 = LocalDateTime.of(2025, 8, 15, 15, 15, 0);
    private static final LocalDateTime dt_2025_08_15__15_30 = dt_2025_08_15__15_15.plusMinutes(15);
    private static final LocalDateTime dt_2025_08_15__15_45 = dt_2025_08_15__15_15.plusMinutes(30);
    private static final LocalDateTime dt_2025_08_15__16_00 = dt_2025_08_15__15_15.plusHours(1);

    private static final BigDecimal d_09 = BigDecimal.valueOf(9);
    private static final BigDecimal d_10 = BigDecimal.TEN;
    private static final BigDecimal d_11 = BigDecimal.valueOf( 11);
    private static final BigDecimal d_12 = BigDecimal.valueOf( 12);

    public static List<Aggregate> makeAggrList() {
        return List.of(
                Aggregate.of(dt_2025_08_15__15_15, d_10),
                Aggregate.of(dt_2025_08_15__15_30, d_09),
                Aggregate.of(dt_2025_08_15__15_45, d_12),
                Aggregate.of(dt_2025_08_15__16_00, d_11)
        );
    }

    public static void main(String[] args) {
        List<Aggregate> ctrl0Aggrs = makeAggrList();
        List<Aggregate> ctrl1Aggrs = makeAggrList();
        List<Aggregate> ctrl2Aggrs = makeAggrList();
        List<Aggregate> ctrl3Aggrs = makeAggrList();

        List<Aggregate> allAggrs = Stream.of( ctrl0Aggrs, ctrl1Aggrs, ctrl2Aggrs, ctrl3Aggrs)
                .flatMap( Collection::stream)
                .toList();

        Map<MeasurementType, List<Aggregate>> in = new EnumMap<>(MeasurementType.class);
        in.put( MeasurementType.P, allAggrs);

        Map<MeasurementType, List<Aggregate>> out = sumAggregatesByMeasurementTime( in);
    }

    // todo: return EnumMap
    private static Map<MeasurementType, List<Aggregate>> sumAggregatesByMeasurementTime(Map<MeasurementType, List<Aggregate>> inputMap) {
        return inputMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue()
                        .stream()
                        .collect(Collectors.groupingBy(Aggregate::measurementTime,
                                Collectors.reducing(BigDecimal.ZERO, Aggregate::value, BigDecimal::add)
                        ))
                        .entrySet()
                        .stream()
                        .map(e -> new Aggregate(e.getKey(), e.getValue()))
                        .sorted(Comparator.comparing(Aggregate::measurementTime))
                        .toList()
        ));
    }
}
