import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {
    private ArrayList<Wydarzenie>[] kalendarz;
    public Kalendarz() {
        kalendarz = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            kalendarz[i] = new ArrayList<>();
        }
    }
    public void dodajWydarzenie(int day, Spotkanie spotkanie) {
        kalendarz[day-1].add(spotkanie);
    }

    public void dodajWydarzenie(int day, Zadanie zadanie) { kalendarz[day-1].add(zadanie); }
    public void usunSpotkanie(int day, int id) {
        int licznik = 0;
        for (int i = 0; i < kalendarz[day-1].size(); i++) {
            if (kalendarz[day-1].get(i) instanceof Spotkanie) {
                if (licznik == id) {
                    kalendarz[day-1].remove(i);
                    break;
                }
                licznik++;
            }
        }
    }
    public void usunZadanie(int day, int id) {
        int licznik = 0;
        for (int i = 0; i < kalendarz[day-1].size(); i++) {
            if (kalendarz[day-1].get(i) instanceof Zadanie) {
                if (licznik == id) {
                    kalendarz[day-1].remove(i);
                    break;
                }
                licznik++;
            }
        }
    }
    public ArrayList<Wydarzenie> wyswietlWydarzenia(int day, Predicate<Wydarzenie> predykat) {
        ArrayList<Wydarzenie> tmp = new ArrayList<>();
        for (int i = 0; i < kalendarz[day-1].size(); i++) {
            if (predykat.test(kalendarz[day-1].get(i))) {
                tmp.add(kalendarz[day-1].get(i));
            }
        }
        return tmp;
    }
}
