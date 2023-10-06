import countdownlatch.HuntRunnable;
import countdownlatch.SellRunnable;
import countdownlatch.SleepRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        List<Runnable> tasks = new ArrayList<>();
        tasks.add(new HuntRunnable(countDownLatch));
        tasks.add(new SellRunnable(countDownLatch));
        tasks.add(new SleepRunnable(countDownLatch));

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (Runnable task : tasks) {
            service.execute(task);
        }

        countDownLatch.await();

        System.out.println("Team is ready for quest!");


    }

}