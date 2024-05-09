    public class NumereComplexe {
    double real;
    double imaginar;

        public NumereComplexe() {
            this.real = real;
            this.imaginar = imaginar;
        }
    public NumereComplexe(double real, double imaginar) {
        this.real = real;
        this.imaginar = imaginar;
    }

    public double getReal() {
        return real;
    }

    public double getImaginar() {
        return imaginar;
    }

    public NumereComplexe sumaNrComplexe (NumereComplexe numar1, NumereComplexe numar2) {
        NumereComplexe rezultat = new NumereComplexe(numar1.getReal() + numar2.getReal() , numar1.getImaginar() + numar2.getImaginar());
        return rezultat;
    }

        @Override
        public String toString() {
            return "NumereComplexe{" +
                    "real=" + real +
                    ", imaginar=" + imaginar +
                    '}';
        }
    }



