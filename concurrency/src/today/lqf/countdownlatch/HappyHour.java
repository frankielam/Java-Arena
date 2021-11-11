package today.lqf.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HappyHour {
    
    public void getBeers() {
        System.out.println("Let's get beer together. " + System.currentTimeMillis() );
    }
    
    public void doWork() {
        int friends = 3;
        
        CountDownLatch latch = new CountDownLatch(friends);

        for (int i = 0; i < friends; i++) {
            new Thread(new Working(i, latch)).start();
        }

        try {
            latch.await();      // Until count down to 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // All friends finish the job. Get beers together
        getBeers();
    }

    public static void main(String[] args) {
        new HappyHour().doWork();
    }

}
