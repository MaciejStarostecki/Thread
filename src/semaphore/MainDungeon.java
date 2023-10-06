import executorservice.ExecutorServiceTask;
import incremetingvolatileproblem.IncrementingRunnable;
import incremetingvolatileproblem.ReadingRunnable;
import incremetingvolatileproblem.SharedCounter;
import semaphore.Dungeon;
import synchronizedproblem.SynchronizedCounter;
import synchronizedproblem.SynchronizedRunnable;
import waitandnotify.WaitAndNotifyExaple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Dungeon dungeon = new Dungeon(4);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    dungeon.tryToEnter();
                } catch (InterruptedException e) {
                    
                }
            });
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