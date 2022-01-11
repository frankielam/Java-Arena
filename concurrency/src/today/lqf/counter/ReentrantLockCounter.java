package today.lqf.counter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class ReentrantLockCounter {

    Lock lock = new java.util.concurrent.locks.ReentrantLock();
    int count = 0;

    public void add(int n) {
        synchronized (this) {
            count += n;
            System.out.println(count);
            try {
                Thread.sleep(100L);
            } catch (Exception e) {

            }
        }

    }

    

    public void add2(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            System.out.println(count);
            lock.unlock();
        }
    }

    public void add3(int n) {
        try {
            if (lock.tryLock(2, TimeUnit.NANOSECONDS)) {

                try {
                    count += n;
                } finally {
                    System.out.println(count);
                    lock.unlock();
                }
            } else {
                System.out.println("try lock fail.\t" + count);
            }
        } catch (Exception e) {
            System.out.println("try lock fail.\t" + count);
        }
    }

    public static void main(String[] args) {
        ReentrantLockCounter obj = new ReentrantLockCounter();
        obj.count = 0;
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
//                        obj.add(1);
//                        obj.add2(1);
                        obj.add3(1);
                    }
                }
            }).start();
        }

    }

}
