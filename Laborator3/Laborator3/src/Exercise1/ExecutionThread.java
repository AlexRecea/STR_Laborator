package Exercise1;

import java.util.concurrent.locks.ReentrantLock;
public class ExecutionThread extends Thread {
    int sleep;
    int[] activity1, activity2;
    ReentrantLock lock1, lock2;

    public ExecutionThread(int sleep, int[] activity1, int[] activity2, ReentrantLock lock1, ReentrantLock lock2) {
        this.sleep = sleep;
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        while (true) {


            System.out.println(this.getName() + " - STATE 1");
            int k = (int) Math.round(Math.random() * (activity1[1] - activity1[0]) + activity1[1]);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - TRANSITION 1 - 2");
            lock1.lock();
            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[1]);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - TRANSITION 2 - 3");
            boolean locked = lock2.tryLock();
            if (locked) {
                System.out.println(this.getName() + " - STATE 3");
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock1.unlock();
                lock2.unlock();
            } else {
                lock1.unlock();
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock1.lock();
                lock2.lock();
                System.out.println(this.getName() + " - STATE 3");
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock1.unlock();
                lock2.unlock();
            }


            System.out.println(this.getName() + " - TRANSITION 3 - 4");

            System.out.println(this.getName() + " - STATE 4");

        }
    }
}