package today.lqf.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Swimming implements Runnable {

    static int WINNER = -1;
    static AtomicInteger reachCount = new AtomicInteger(0);

    int no = -1;

    CyclicBarrier cyclicBarrier;

    public Swimming(int no, CyclicBarrier cyclicBarrier) {
        this.no = no;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            System.out.format("#%d athlete is ready.\n", no);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("#" + no + " athlete staring swimming at " + System.currentTimeMillis());

        try {
            Thread.sleep(1000L * (1 + new Random().nextInt(3))); // Swimming random seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("#" + no + " athlete reaches the finish line at " + System.currentTimeMillis());

        // 第一到达终点者
        if (WINNER == -1) {
            WINNER = no;
            System.out.println("------- #" + WINNER + " athlete saying: YES! I won it. -------");
        }

        reachCount.incrementAndGet();
    }
}
