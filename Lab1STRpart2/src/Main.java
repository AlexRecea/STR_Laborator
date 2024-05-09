//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Resursa resursa = new Resursa();
        Firs fs = new Firs(resursa);
        Firc fc = new Firc(resursa);

        fs.start();
        fc.start();



        }
    }