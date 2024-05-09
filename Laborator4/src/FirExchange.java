import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class FirExchange extends Thread{
    List<Integer> list = new ArrayList<Integer>();
    int sleepTime;
    Exchanger<List<Integer>> exchanger;
    String name;

    FirExchange(Exchanger<List<Integer>> exchanger, String name, int sleepTime) {
        this.exchanger = exchanger;
        this.name = name;
        this.sleepTime = sleepTime;
    }
    public void afisLista() {
//        for (Integer i : list) {
//            System.out.println(i);
//        }
        System.out.println(name + list);
        //cel mai simplu mod de afisare al unei liste
    }

    public void run() {
        int noElem = (int)Math.round(Math.random()*3 + 1);
        for (int i = 0; i < noElem; i++) {
            int elem = (int)Math.round(Math.random()*100);
            list.add(new Integer(elem));
        }
        this.afisLista();
        try {
            Thread.sleep(this.sleepTime);
            this.list = exchanger.exchange(this.list);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.afisLista();
    }
}


