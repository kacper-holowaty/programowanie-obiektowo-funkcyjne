import java.time.LocalTime;
import java.util.ArrayList;

public class Kalendarz {
    private ArrayList<Spotkanie>[] kalendarz;

    public Kalendarz() {
        kalendarz = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            kalendarz[i] = new ArrayList<>();
        }
    }
    public void dodajSpotkanie(int day, Spotkanie spotkanie) {
        kalendarz[day-1].add(spotkanie);
    }

    public void usunSpotkanie(int day, int id) {
        kalendarz[day-1].remove(id);
    }

    public ArrayList<Spotkanie> zwrocSpotkania(int day) {
        return kalendarz[day-1];
    }
    public ArrayList<Spotkanie> zwrocSpotkaniaOPodanymPriorytecie (int day, String priorytet) {
        ArrayList<Spotkanie> tmp = new ArrayList<>();

        for (int i = 0; i < kalendarz[day-1].size(); i++) {
            if (kalendarz[day-1].get(i).zwrocPriorytet().equals(priorytet)) {
                tmp.add(kalendarz[day-1].get(i));
            }
        }
        return tmp;
    }

    public ArrayList<Spotkanie> zwrocSpotkaniaZaczynajaceSie (int day, LocalTime czas) {
        ArrayList<Spotkanie> tmp = new ArrayList<>();

        for (int i = 0; i < kalendarz[day-1].size(); i++) {
            if (kalendarz[day-1].get(i).zwrocCzasRozpoczecia().isAfter(czas)) {
                tmp.add(kalendarz[day-1].get(i));
            }
        }
        return tmp;
    }
}
