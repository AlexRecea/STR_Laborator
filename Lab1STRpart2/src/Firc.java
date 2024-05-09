public class Firc extends Thread{
        Resursa res;
        Firc (Resursa res) {
            this.res = res;
        }


    public void run() {
        for (int i=1;i<=10;i++) {
            System.out.println("Am citit: " + res.citeste());
        }
    }
}
