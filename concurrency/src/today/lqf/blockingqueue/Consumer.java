package today.lqf.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("\t\tStore: Ready to sale product");

        while (true) {
            try {
                if (queue.isEmpty()) {
                    System.out.println("\t\tOh, NO. Sold out. Waitting for the new products....");
                }
                System.out.println("\t\t\t\tSold " + queue.take() + " at " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
