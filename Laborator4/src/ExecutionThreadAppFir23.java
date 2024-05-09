import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecutionThreadAppFir23 extends Thread{

    int activity_min, activity_max, sleep;
    CyclicBarrier cyclicBarrier;
    Semaphore semaphore;
    CountDownLatch countDownLatch;

    public ExecutionThreadAppFir23(int activity_min, int activity_max, int sleep, Semaphore semaphore, CountDownLatch countDownLatch) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        try {
            semaphore.acquire();
            System.out.println(this.getName() + " se ia jeton");
            Thread.sleep(sleep*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 2");
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

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




