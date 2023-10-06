import executorservice.ExecutorServiceTask;
import incremetingvolatileproblem.IncrementingRunnable;
import incremetingvolatileproblem.ReadingRunnable;
import incremetingvolatileproblem.SharedCounter;
import synchronizedproblem.SynchronizedCounter;
import synchronizedproblem.SynchronizedRunnable;
import waitandnotify.WaitAndNotifyExaple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            executorService1.submit(new ExecutorServiceTask());
        }

        for (int i = 0; i < 3; i++) {
            executorService2.submit(new ExecutorServiceTask());
        }

        for (int i = 0; i < 100; i++) {
            executorService3.submit(new ExecutorServiceTask());
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