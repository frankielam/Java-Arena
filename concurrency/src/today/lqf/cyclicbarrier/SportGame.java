package today.lqf.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class SportGame {

    public static void main(String[] args) {
        int athleteNumber = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(athleteNumber, new Referee(athleteNumber));

        for (int i = 0; i < athleteNumber; i++) {
            new Thread(new Swimming(i, cyclicBarrier)).start();
        }

    }

}
