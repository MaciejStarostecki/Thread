import callable.Divider;
import executorservice.ExecutorServiceTask;
import incremetingvolatileproblem.IncrementingRunnable;
import incremetingvolatileproblem.ReadingRunnable;
import incremetingvolatileproblem.SharedCounter;
import semaphore.Dungeon;
import synchronizedproblem.SynchronizedCounter;
import synchronizedproblem.SynchronizedRunnable;
import waitandnotify.WaitAndNotifyExaple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<Double>> list = new ArrayList<>();

        for (int i = 0; i <5; i++) {
            Future<Double> result = executorService.submit(new Divider((double) i * 5));
            list.add(result);
        }

        for (Future<Double> result : list) {
            System.out.println(result.get()); 
        }

    }

    public static void mainThread() {
        System.out.println("Starting loop: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main Thread loop: " + i);
        }
    }

    public static void secondThread() {
        System.out.println("Starting second loop: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.println("Second Thread loop: " + i);

        }
    }
}