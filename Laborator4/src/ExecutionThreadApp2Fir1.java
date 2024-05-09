import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecutionThreadApp2Fir1 extends Thread {

    int activity_min, activity_max, sleep;
    CyclicBarrier cyclicBarrier;
    Semaphore semaphore1, semaphore2;
    CountDownLatch countDownLatchFinal, countDownLatchInitial;

    public ExecutionThreadApp2Fir1(int activity_min, int activity_max, int sleep, CountDownLatch countDownLatchFinal, CountDownLatch countDownLatchInitial) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.countDownLatchFinal = countDownLatchFinal;
        this.countDownLatchInitial = countDownLatchInitial;
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
        System.out.println(this.getName() + " -- " + countDownLatchInitial.getCount());
       countDownLatchInitial.countDown();
        System.out.println(this.getName() + " - " + countDownLatchInitial.getCount());
        System.out.println(this.getName() + " se pun jetoane");

        System.out.println(this.getName() + " - STATE 3");

        countDownLatchFinal.countDown();
        try {
            countDownLatchFinal.await();
            System.out.println(this.getName() + " - Gata");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}



