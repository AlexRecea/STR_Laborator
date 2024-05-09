package Exercise2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Semafor extends Thread {
    Semaphore monitor1, monitor2;
    CountDownLatch latch;
    int[] activity1, activity2;
    int sleep;
    int m1,p1,m2,p2;
    Thread t;

    public Semafor(Semaphore monitor1, int[] activity1, int[] activity2, int sleep, Thread t, int m1, int p1) {
        this.monitor1 = monitor1;
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.sleep = sleep;
        this.t = t;
        this.m1 = m1;
        this.p1 = p1;

    }

    public void run() {
        while (true) {


            System.out.println(this.getName() + " - STATE 1");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println(this.getName() + " - STATE 2");
                monitor1.acquire(m1);
                try {
                    System.out.println(this.getName() + " - STATE 3");
                    int k = (int) Math.round(Math.random() * (activity1[1] - activity1[0]) + activity1[1]);
                    for (int i = 0; i < k * 100000; i++) {
                        i++;
                        i--;
                    }
                    monitor1.release(p1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            System.out.println(this.getName() + " - STATE 4");
        }
    }
}