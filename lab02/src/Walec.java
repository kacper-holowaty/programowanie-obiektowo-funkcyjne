public class Walec {
    private double r;
    private double h;
    public Walec(double r, double h) {
        this.r = r;
        this.h = h;
    }
    public Walec() {
        this.r = r;
        this.h = h;
    }
    public void ustawPromien (double promien) {
        r = promien;
    }
    public void ustawWysokosc (double wysokosc) {
        h = wysokosc;
    }
    public double odczytajPromien () {
        return r;
    }
    public double odczytajWysokosc () {
        return h;
    }
    public double obliczPPP () {
        return Math.PI * Math.pow(r, 2);
    }
    public double obliczPPB () {
        return 2 * Math.PI * r * h;
    }
    public double obliczPPC () {
        return 2 * obliczPPP() + obliczPPB();
    }
    public double objetosc () {
        return obliczPPP() * h;
    }
}
