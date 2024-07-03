import java.time.LocalTime;
public abstract sealed class Wydarzenie permits Zadanie, Spotkanie {
    protected String opis;
    protected LocalTime czasRozpoczecia;
    protected LocalTime czasZakonczenia;
    public static final LocalTime NAJWCZESNIEJSZA_GODZINA = LocalTime.of(8,0);
    public abstract String zwrocPriorytetAlboStatus();
    public LocalTime zwrocCzasRozpoczecia() {
        return czasRozpoczecia;
    }
    public LocalTime zwrocCzasZakonczenia() {
        return czasZakonczenia;
    }
}
