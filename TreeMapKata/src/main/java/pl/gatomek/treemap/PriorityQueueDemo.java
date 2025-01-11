package pl.gatomek.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.naturalOrder();
        TreeMap<String,String> map = new TreeMap<>( comparator);

        map.put( "e", "epsilon");
        map.put( "b", "beta");
        map.put( "c", "charlie");
        map.put( "a", "alpha");
        map.put( "d", "delta");
        map.put( "a", "alpha 1");

        System.out.println( "--");
        while( ! map.isEmpty()) {
            Map.Entry<String, String> entry = map.pollFirstEntry();
            System.out.println( entry.getKey() + " : " + entry.getValue());
        }
    }
}
