import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private ArrayList<Nieruchomosc> oferty;

    public ListaOfert() {
        oferty = new ArrayList<>();
    }
    public void dodajOferteSprzedazyDomu(Dom dom) {
        oferty.add(dom);
    }
    public void dodajOferteSprzedazyMieszkania(Mieszkanie mieszkanie) {
        oferty.add(mieszkanie);
    }
    public ArrayList<Nieruchomosc> wyswietlOferty(Predicate<Nieruchomosc> predykat) {
        ArrayList<Nieruchomosc> tmp = new ArrayList<>();
        for (int i = 0; i < oferty.size(); i++) {
            if (predykat.test(oferty.get(i))) {
                tmp.add(oferty.get(i));
            }
        }
        return tmp;
    }

}
