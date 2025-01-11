package pl.gatomek.treemap;

import java.util.Comparator;
import java.util.TreeMap;

public class PersonTreeMapDemo {
    public static void main(String[] args) {
        System.out.println( "Person Tree Map Demo");

        //TreeMap<Person, Integer> map = new TreeMap<>( Comparator.comparingInt( o -> o.age()));
        TreeMap<Person, Integer> map = new TreeMap<>( Comparator.comparingInt( Person::age));

        map.put( new Person( "Peter", 21), 17);
        map.put( new Person( "Thomas", 13), 15);
        map.put( new Person( "Thomas", 13), 121);   // updating prev entry!

        System.out.println( map);

        System.out.println( map.firstEntry());
        System.out.println( map.lastEntry());
    }
}
