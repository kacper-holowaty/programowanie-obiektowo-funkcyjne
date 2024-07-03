import java.time.LocalTime;

public final class Spotkanie extends Wydarzenie {
    private String priorytet;
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
    public String zwrocPriorytetAlboStatus() {
        return priorytet;
    }
}
