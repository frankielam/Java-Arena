package today.lqf.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Working implements Runnable {

    int no = -1;

    CountDownLatch countDownLatch;

    public Working(int no, CountDownLatch countDownLatch) {
        this.no = no;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000L * no);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#" + no + " finish job at "  + System.currentTimeMillis());
        countDownLatch.countDown();
    }
}
