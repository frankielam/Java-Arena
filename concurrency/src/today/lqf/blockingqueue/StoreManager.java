package today.lqf.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StoreManager {

    public static void main(String[] args) {
        int maxSize = 30;
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(maxSize);
        
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        
        // 3 threads to make products
        new Thread(producer, "Machine_1").start();
        new Thread(producer, "Machine_2").start();
        new Thread(producer, "Machine_3").start();
        
        System.out.println("The store is opening..");
        
        // 1 thread to sale products
        new Thread(consumer).start();
        
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // the fourth thread to make products
        new Thread(producer, "Machine_4").start();
    }

}
