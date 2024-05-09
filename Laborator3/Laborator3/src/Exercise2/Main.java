package Exercise2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String args[]) {
        Semaphore monitor1 = new Semaphore(1);

        int[] activity1 = {2, 5};
        int[] activity2 = {4, 6};

        Semafor t1 = new Semafor(monitor1, activity1, activity2,4, null, 2, 1);
        while(true) {
            CountDownLatch latch = new CountDownLatch(3);

            Semafor t1 = new Semafor(monitor1,activity_min, activity_max, 4, null, latch);
            t1.start();

            new Semafor(monitor1, activity_min2, activity_max2, 5, t1, latch).start();

            latch.countDown();

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}