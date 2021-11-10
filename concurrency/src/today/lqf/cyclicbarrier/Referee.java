package today.lqf.cyclicbarrier;

/**
 * 裁判员
 */
public class Referee implements Runnable {

    int athleteNumber;

    public Referee(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    @Override
    public void run() {
        // 运动员就位后开始
        System.out.println("###### Referee: Ready ~ GO! ");

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new ClosingCeremony(athleteNumber)).start();

    }

}

// 闭幕式
class ClosingCeremony implements Runnable {

    int athleteNumber;

    public ClosingCeremony(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    @Override
    public void run() {
        while (true) {
            // 所有人到达终点后结束
            if (Swimming.reachCount.get() == athleteNumber) {
                System.out.println("###### ClosingCeremony: Congrats. The winner is #" + Swimming.WINNER);
                System.out.println("###### ClosingCeremony: Sport game finished. " + System.currentTimeMillis());
                break;
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}