import java.time.LocalTime;

public final class Zadanie extends Wydarzenie {
    private String status;

    @Override
    public String toString() {
        return "Opis: " + opis + ", godzina rozpoczęcia: " + czasRozpoczecia + ", godzina zakończenia: " + czasZakonczenia + ", status: "+status;
    }
    public Zadanie(String opis, LocalTime czasRozpoczecia, LocalTime czasZakonczenia, String status) {
        this.opis = opis;
        this.czasRozpoczecia = czasRozpoczecia;
        this.czasZakonczenia = czasZakonczenia;
        this.status = status;
    }
    public String zwrocPriorytetAlboStatus() {
        return status;
    }

}

