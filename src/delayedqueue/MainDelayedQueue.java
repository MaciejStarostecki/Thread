import delayedqueue.DelayedMission;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<DelayedMission> missionQueue = new DelayQueue<>();

        missionQueue.put(new DelayedMission("Character woke up", 5000));
        missionQueue.put(new DelayedMission("Character returning from hunt", 9000));
        missionQueue.put(new DelayedMission("Character sold items", 7000));

        while (!missionQueue.isEmpty()) {
            DelayedMission take = missionQueue.take();
            System.out.println(take.getMission());
        }

        System.out.println("Team is ready for the quest!");

    }

}