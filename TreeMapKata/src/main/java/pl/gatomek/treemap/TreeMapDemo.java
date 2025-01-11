package pl.gatomek.treemap;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        System.out.println("TreeMap kata");

        Comparator<String> comparator = Comparator.naturalOrder();
        TreeMap<String,String> map = new TreeMap<>( comparator);

        map.put( "e", "epsilon");
        map.put( "b", "beta");
        map.put( "c", "charlie");
        map.put( "a", "alpha");
        map.put( "d", "delta");

        System.out.println( map.firstKey());
        System.out.println( map.lastKey());

        SortedMap<String, String> sortedMapTo = map.headMap("c",true);
        System.out.println( sortedMapTo.keySet());

        SortedMap<String, String> sortedMapFrom = map.tailMap("c");
        System.out.println( sortedMapFrom.keySet());

        SortedMap<String, String> emptyMap = sortedMapTo.headMap("a");
        System.out.println( emptyMap.keySet());
    }
}