import java.time.LocalTime;

public class Spotkanie {
    private String opis;
    private LocalTime czasRozpoczecia;
    private LocalTime czasZakonczenia;
    private String priorytet;
    public static final LocalTime NAJWCZESNIEJSZA_GODZINA = LocalTime.of(8,0);

    public Spotkanie(String opis, LocalTime czasRozpoczecia, LocalTime czasZakonczenia, String priorytet) {
        this.opis = opis;
        this.czasRozpoczecia = czasRozpoczecia;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = priorytet;
    }

    @Override
    public String toString() {
        return "Opis: " + opis + ", godzina rozpoczęcia: " + czasRozpoczecia + ", godzina zakończenia: " + czasZakonczenia + ", priorytet: " + priorytet;
    }
    public String zwrocPriorytet() {
        return priorytet;
    }
    public LocalTime zwrocCzasRozpoczecia() {
        return czasRozpoczecia;
    }
    public LocalTime zwrocCzasZakonczenia() {
        return czasZakonczenia;
    }
}
