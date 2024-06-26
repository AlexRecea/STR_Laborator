package Exercise1;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int sleep = 100;
        int[] activity1 = {1, 3};
        int[] activity2 = {2, 4};
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        new ExecutionThread(sleep, activity1, activity2, lock1, lock2).start();
        new ExecutionThread(sleep, activity1, activity2, lock2, lock1).start();
    }
}