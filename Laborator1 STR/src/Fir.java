public class Fir extends Thread{
    private int p;
    private int s;
    Fir (int p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i=0; i<50; i+=p){
            s += i;
        }
        System.out.println(getName() + " s=" + s);
    }

    public int getSuma() {
        return s;
    }
}
