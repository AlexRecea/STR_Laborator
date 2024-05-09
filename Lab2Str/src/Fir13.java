package Lab2;
public class Fir13 extends Thread{

    Integer monitor;
    int activity_min, activity_max, sleep;

    public Fir13(Integer monitor, int activity_min, int activity_max,int sleep){

        this.monitor = monitor;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
    }

    @Override
    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor) {

            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            try {
                Thread.sleep(this.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " - STATE 3");
    }

}
