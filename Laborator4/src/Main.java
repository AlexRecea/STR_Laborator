import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
public class Main {
    public static void main(String[] args) {
        CyclicBarrier bariera = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("Rutina barierei");
            }
        }
        );
        /* cod pentru primul exemplu (codul din laborator)
        Fir fir1 = new Fir(bariera);
        Fir fir2 = new Fir(bariera);
        Fir fir3 = new Fir(bariera);
        fir1.start();
        fir2.start();
        fir3.start();
         */

        /* cod pentru al doilea exercitiu (exercitiul 2 din lab )
        Semaphore semaphorefir13 = new Semaphore(1);
        Semaphore semaphorefir2 = new Semaphore(1);
        ExecutionThreadFir13 fir1 = new ExecutionThreadFir13(2, 4, 4, semaphorefir13,bariera);
        ExecutionThreadFir13 fir3 = new ExecutionThreadFir13(2, 5, 5, semaphorefir13, bariera);
        ExecutionThread fir2 = new ExecutionThread(3, 6, 3, semaphorefir13, semaphorefir2, bariera);

        fir1.start();
        fir2.start();
        fir3.start();
        */

        /*
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutionThreadAppFir1 fir1 = new ExecutionThreadAppFir1(2,3,7, semaphore1, semaphore2, countDownLatch);
        ExecutionThreadAppFir23 fir2 = new ExecutionThreadAppFir23(3,5,5,semaphore1,countDownLatch);
        ExecutionThreadAppFir23 fir3 = new ExecutionThreadAppFir23(4,6,5,semaphore2,countDownLatch);
        fir1.start();
        fir2.start();
        fir3.start();
        */

        CountDownLatch countDownLatchInitial = new CountDownLatch(1);
        CountDownLatch countDownLatchFinal = new CountDownLatch(3);
        ExecutionThreadApp2Fir1 fir1 = new ExecutionThreadApp2Fir1(2,3,7,countDownLatchFinal,countDownLatchInitial);
        ExecutionThreadApp2Fir23 fir2 = new ExecutionThreadApp2Fir23(3,5,5,countDownLatchFinal,countDownLatchInitial);
        ExecutionThreadApp2Fir23 fir3 = new ExecutionThreadApp2Fir23(4,6,5,countDownLatchFinal,countDownLatchInitial);
        fir1.start();
        fir2.start();
        fir3.start();

    }
}