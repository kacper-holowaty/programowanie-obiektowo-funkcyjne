import java.time.LocalDate;

public abstract sealed class Nieruchomosc permits Dom, Mieszkanie {
    protected String ulica;
    protected int numerDomu;
    protected String miejscowosc;
    protected String kodPocztowy;
    protected double powierzchnia;
    protected double cena;
    protected LocalDate dataObowiazywania;

    public Nieruchomosc(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia, double cena, LocalDate dataObowiazywania) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataObowiazywania = dataObowiazywania;
    }

    public LocalDate zwrocDateObowiazywania() {
        return dataObowiazywania;
    }
    public String zwrocMiejscowosc() {
        return miejscowosc;
    }
    public double zwrocPowierzchnie() {
        return powierzchnia;
    }
    public double zwrocCene() {
        return cena;
    }
}
