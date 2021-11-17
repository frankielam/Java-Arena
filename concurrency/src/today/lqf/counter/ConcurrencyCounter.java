package today.lqf.counter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyCounter {

    int idx = 0;
    volatile int idx2 = 0;
    int idx3 = 0;
    AtomicInteger atomicIdx4 = new AtomicInteger(0);
    int idx5 = 0;

    public void count() {
        idx++; // idx++ 不是原子性操作
    }

    /**
     * 使用 volatile 变量，无法保证原子性
     */
    public void count2() {
        idx2++;
    }

    /**
     * 使用 synchronized
     */
    public synchronized void count3() {
        idx3++;
    }

    /**
     * 使用 AtomicInteger 保证原子性
     */
    public void count4() {
        atomicIdx4.incrementAndGet();
    }

    Lock lock = new ReentrantLock();

    /**
     * 使用 ReentrantLock
     */
    public void count5() {
        lock.lock();
        idx5++;
        lock.unlock();
    }

    public int result() {
        if (idx2 > 0)
            return idx2;
        if (idx3 > 0)
            return idx3;
        if (atomicIdx4.get() > 0)
            return atomicIdx4.get();
        if (idx5 > 0)
            return idx5;
        return idx;
    }

    public static void main(String[] args) {
        int threads = 2, times = 5000;
        // demo 1，不符合预期
        ConcurrencyCounter counter = new ConcurrencyCounter();
        for (int i = 0; i < threads; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < times; j++) {
                        counter.count();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 1) { // 等待前面线程执行完
            Thread.yield();
        }
        System.out.printf("counter expect %d, actually %d\n", threads * times, counter.result());

        // demo 2，不符合预期
        ConcurrencyCounter counter2 = new ConcurrencyCounter();
        for (int i = 0; i < threads; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < times; j++) {
                        counter2.count2();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.printf("counter2 expect %d, actually %d\n", threads * times, counter2.result());

        // demo 3，符合预期
        ConcurrencyCounter counter3 = new ConcurrencyCounter();
        for (int i = 0; i < threads; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < times; j++) {
                        counter3.count3();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.printf("counter3 expect %d, actually %d\n", threads * times, counter3.result());

        // demo 4，符合预期
        ConcurrencyCounter counter4 = new ConcurrencyCounter();
        for (int i = 0; i < threads; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < times; j++) {
                        counter4.count4();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.printf("counter4 expect %d, actually %d\n", threads * times, counter4.result());

        // demo 5，符合预期
        ConcurrencyCounter counter5 = new ConcurrencyCounter();
        for (int i = 0; i < threads; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < times; j++) {
                        counter5.count5();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.printf("counter5 expect %d, actually %d\n", threads * times, counter5.result());

    }
}