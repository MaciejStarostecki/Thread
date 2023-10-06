import cyclicbarrier.CyclicBarrierRunnable;
import priorityblockingqueue.Case;
import priorityblockingqueue.CaseRunnable;
import priorityblockingqueue.HospitalRunnable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);

        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Knight is ready to fight"));

        service.execute(new CyclicBarrierRunnable(
                "Preparing armor",
                "Bringing armor",
                5000,
                barrier));

        service.execute(new CyclicBarrierRunnable(
                "Preparing horse",
                "Bringing horse",
                7000,
                barrier));

        service.execute(new CyclicBarrierRunnable(
                "Preparing sword",
                "Bringing sword",
                9000,
                barrier));


    }

}