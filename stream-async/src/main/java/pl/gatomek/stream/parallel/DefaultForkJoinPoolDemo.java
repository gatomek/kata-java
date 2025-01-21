package pl.gatomek.stream.parallel;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class DefaultForkJoinPoolDemo {

    private static Integer doWork( Integer n) {
        try {
            Thread.sleep( Duration.ofMillis( 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println("Default ForkJoinPool Demo: Async Streams");

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println( "ps: " + forkJoinPool.getPoolSize());

        List<Integer> list = List.of(0,1,2,3,4,5,6,7,8,9);
        list.parallelStream().map( DefaultForkJoinPoolDemo::doWork).forEach(n -> System.out.print( n + " "));

        System.out.println();
        System.out.println( "ps: " + forkJoinPool.getPoolSize());
    }
}
