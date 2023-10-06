import concurrenthashmap.AddingItemsRunnable;
import concurrenthashmap.GettingItemsRunnable;
import cyclicbarrier.CyclicBarrierRunnable;
import exchanger.Item;
import exchanger.WarriorRunnable;
import priorityblockingqueue.Case;
import priorityblockingqueue.CaseRunnable;
import priorityblockingqueue.HospitalRunnable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);

        Exchanger<Item> itemExchanger = new Exchanger<>();

        service.execute(new WarriorRunnable(itemExchanger, new Item("Chain Armor", 0)));
        service.execute(new WarriorRunnable(itemExchanger, new Item("Plate Armor", 1)));
    }

}