import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecutionThreadFir13 extends Thread {

    int activity_min, activity_max, sleep;
    CyclicBarrier cyclicBarrier;
    Semaphore semaphore;

    public ExecutionThreadFir13(int activity_min, int activity_max, int sleep, Semaphore semaphore,CyclicBarrier cyclicBarrier) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.semaphore = semaphore;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");

            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            try {
                Thread.sleep(sleep*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println(this.getName() + " - STATE 3");
            try
            {
                cyclicBarrier.await();
            }

            catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
