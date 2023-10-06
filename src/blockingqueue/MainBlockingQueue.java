import blockingqueue.CustomerRunnable;
import blockingqueue.RestaurantRunnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);

        BlockingQueue<String> orderQueue = new ArrayBlockingQueue<>(10);

        service.execute(new CustomerRunnable(orderQueue, "Chicken", "Pasta", "Beef"));
        service.execute(new CustomerRunnable(orderQueue, "Lamb", "Soup", "Dumplings"));
        service.execute(new RestaurantRunnable(orderQueue));




        System.out.println("Team is ready for quest!");


    }

}