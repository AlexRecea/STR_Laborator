public class Resursa {
    int res;
    synchronized public void scrie (int a) {
        res = a;
        try {
            wait(0, 1);
        }catch (Exception e) {}
        notify();
    }
    synchronized public int citeste () {
        try {
            wait();
        }catch (Exception e) { }
        notify();
        return res;
    }
}
