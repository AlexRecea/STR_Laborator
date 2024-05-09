public class Firs extends Thread {
    Resursa res;
    public Firs (Resursa res) {
        this.res = res;
    }

    public void run() {
        for (int i=1; i<=10; i++) {
            res.scrie(i);
            System.out.println("Am scris: " + i);
        }

    }
}
