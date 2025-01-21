package pl.gatomek.stream.parallel;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class CustomForkJoinPoolDemo {

    private static Integer doWork( Integer n) {
        try {
            Thread.sleep( Duration.ofMillis( 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println("Custom ForkJoinPool Demo: Async Streams");

        ForkJoinPool forkJoinPool = null;
        try {
            List<Integer> list = List.of(0,1,2,3,4,5,6,7,8,9);
            forkJoinPool = new ForkJoinPool( 10);

            ForkJoinTask<?> submit = forkJoinPool.submit(
                    () -> list.parallelStream().map(CustomForkJoinPoolDemo::doWork).forEach(n -> System.out.print( n + " "))
            );
            submit.join();
        } finally {
            if( forkJoinPool != null)
                forkJoinPool.shutdown();
        }
    }
}