package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class SellHuntRunnable implements Runnable {

    private CountDownLatch countDownLatch;

    public SellHuntRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        sell();
    }

    private void sell() {
        System.out.println("Character from the Thread " + Thread.currentThread().getName() + " is selling items.");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Character from the Thread " + Thread.currentThread().getName() + " sold items.");
    }
}
