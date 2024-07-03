import java.util.ArrayList;
import java.util.function.Predicate;

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

    public ArrayList<Spotkanie> wyswietlSpotkania(int day, Predicate<Spotkanie> predykat) {
        ArrayList<Spotkanie> tmp = new ArrayList<>();
        for (int i = 0; i < kalendarz[day-1].size(); i++) {
            if (predykat.test(kalendarz[day-1].get(i))) {
                tmp.add(kalendarz[day-1].get(i));
            }
        }
        return tmp;
    }
}
