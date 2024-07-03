import java.time.LocalDate;

public final class Mieszkanie extends Nieruchomosc {
    private int numerMieszkania;
    private int pietro;
    public Mieszkanie(String ulica, int numerDomu, int numerMieszkania, String miejscowosc, String kodPocztowy, double powierzchnia, int pietro, double cena, LocalDate dataObowiazywania) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywania);
        this.numerMieszkania = numerMieszkania;
        this.pietro = pietro;
    }
    @Override
    public String toString() {
        return "Miejscowość: " + miejscowosc + ", kod pocztowy: "+ kodPocztowy +", ulica: " + ulica + ", numer budynku: " + numerDomu + ", numer mieszkania: " + numerMieszkania + ", numer piętra: " + pietro + ", powierzchnia mieszkania: " + powierzchnia + " m2, cena: "+ cena + ", data obowiązywania oferty: "+ dataObowiazywania;
    }
    public int zwrocNumerPietra() {
        return pietro;
    }
}
