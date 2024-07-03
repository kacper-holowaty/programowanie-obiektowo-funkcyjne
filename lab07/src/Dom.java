import java.time.LocalDate;

public final class Dom extends Nieruchomosc {
    private double powierzchniaDzialki;
    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia, double cena, double powierzchniaDzialki, LocalDate dataObowiazywania) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }
    @Override
    public String toString() {
        return "Miejscowość: " + miejscowosc + ", kod pocztowy: "+ kodPocztowy +", ulica: " + ulica + ", numer domu: " + numerDomu + ", powierzchnia domu: " + powierzchnia + " m2, powierzchnia działki: "+ powierzchniaDzialki + " m2, cena: "+ cena + ", data obowiązywania oferty: "+ dataObowiazywania;
    }
}
