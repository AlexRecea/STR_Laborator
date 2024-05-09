public class Main {
    public static void main(String[] args) {
            Fir f1 = new Fir(2);
            Fir f2 = new Fir(3);
            Fir f3 = new Fir(4);

            f1.start();
            f2.start();
            f3.start();

        try {
            f1.join();
            f2.join();
            f3.join();

        } catch (Exception e) {
        }
        System.out.println("sf1= " + f1.getSuma());
        int suma = f1.getSuma() + f2.getSuma() + f3.getSuma();
        System.out.println("Suma este: " + suma);

    }
    }