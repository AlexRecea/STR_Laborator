import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecutionThreadAppFir1 extends Thread {

    int activity_min, activity_max, sleep;
    CyclicBarrier cyclicBarrier;
    Semaphore semaphore1, semaphore2;
    CountDownLatch countDownLatch;

    public ExecutionThreadAppFir1(int activity_min, int activity_max, int sleep, Semaphore semaphore1, Semaphore semaphore2, CountDownLatch countDownLatch) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        try {
            Thread.sleep(sleep*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 2");
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        semaphore1.release();
        semaphore2.release();
        System.out.println(this.getName() + " se pun jetoane");

        System.out.println(this.getName() + " - STATE 3");

        countDownLatch.countDown();
        try {
            countDownLatch.await();
            System.out.println(this.getName() + " - Gata");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}



