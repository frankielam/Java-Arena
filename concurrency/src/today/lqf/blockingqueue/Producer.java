package today.lqf.blockingqueue;

import java.util.concurrent.BlockingQueue;;

public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int size = 10;
        System.out.println(Thread.currentThread().getName() + " start to make products.");
        for (int i = 0; i < size; i++) {
            try {
                // use put() not add()
                queue.put(Thread.currentThread().getName() + "-product-" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
            System.out.println(Thread.currentThread().getName() + " make product-" + i);
        }
    }

}
