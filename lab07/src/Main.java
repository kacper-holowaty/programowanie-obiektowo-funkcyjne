import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("Służę do obsługi listy ofert sprzedaży mieszkań i domów.");
        System.out.println("Mamy następujące opcje uruchomienia programu:");
        System.out.println("1 - dodanie oferty sprzedaży domu");
        System.out.println("2 - dodanie oferty sprzedaży mieszkania");
        System.out.println("3 - wyświetlenie wszystkich aktualnych ofert sprzedaży domów");
        System.out.println("4 - wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań");
        System.out.println("5 - wyświetlenie wszystkich aktualnych ofert sprzedaży domów, w danej miejscowości, o powierzchni nie mniejszej niż podana wartość");
        System.out.println("6 - wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań, w danej miejscowości, nie droższych niż podana wartość i od podanego piętra wzwyż");
        System.out.println("7 - dodanie 5 domów i 7 mieszkań do oferty");
        System.out.println("8 - zakończenie działania programu\n");
    }
    private static void opcja1(ListaOfert listaOfert, Scanner scan) {
        System.out.println("Dodanie oferty sprzedaży domu z podaniem parametrów.");
        System.out.println("Podaj ulicę, na której mieści się dom:");
        String ulica = scan.nextLine();
        scan.nextLine();
        System.out.println("Podaj numer domu:");
        int numerDomu = scan.nextInt();
        scan.nextLine();
        System.out.println("Podaj miejscowość, w której znajduje się dom:");
        String miejscowosc = scan.nextLine();
        System.out.println("Podaj kod pocztowy:");
        String kodPocztowy = scan.nextLine();
        System.out.println("Podaj powierzchnię domu:");
        double powierzchnia = scan.nextDouble();
        System.out.println("Podaj cenę domu:");
        double cena = scan.nextDouble();
        System.out.println("Podaj powierzchnię działki:");
        double powierzchniaDzialki = scan.nextDouble();
        scan.nextLine();
        System.out.print("Podaj datę obowiązywania oferty w formacie YYYY-MM-DD: ");
        String dataString = scan.nextLine();
        LocalDate data = LocalDate.parse(dataString);
        listaOfert.dodajOferteSprzedazyDomu(new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, powierzchniaDzialki, data));
        System.out.println("Dodano ofertę sprzedaży domu.");
    }
    private static void opcja2(ListaOfert listaOfert, Scanner scan) {
        System.out.println("Dodanie oferty sprzedaży mieszkania z podaniem parametrów.");
        System.out.println("Podaj ulicę, na której mieści się mieszkanie:");
        String ulica = scan.nextLine();
        scan.nextLine();
        System.out.println("Podaj numer budynku:");
        int numerDomu = scan.nextInt();
        System.out.println("Podaj numer mieszkania:");
        int numerMieszkania = scan.nextInt();
        scan.nextLine();
        System.out.println("Podaj miejscowość, w której znajduje się mieszkanie:");
        String miejscowosc = scan.nextLine();
        System.out.println("Podaj kod pocztowy:");
        String kodPocztowy = scan.nextLine();
        System.out.println("Podaj powierzchnię mieszkania:");
        double powierzchnia = scan.nextDouble();
        System.out.println("Podaj piętro, na którym znajduje się mieszkanie");
        int pietro = scan.nextInt();
        System.out.println("Podaj cenę mieszkania:");
        double cena = scan.nextDouble();
        scan.nextLine();
        System.out.print("Podaj datę obowiązywania oferty w formacie YYYY-MM-DD: ");
        String dataString = scan.nextLine();
        LocalDate data = LocalDate.parse(dataString);
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie(ulica, numerDomu, numerMieszkania, miejscowosc, kodPocztowy, powierzchnia, pietro, cena, data));
        System.out.println("Dodano ofertę sprzedaży mieszkania.");
    }
    private static void opcja3 (ListaOfert listaOfert) {
        System.out.println("Wyświetlenie wszystkich aktualnych ofert sprzedaży domów");
        ArrayList<Nieruchomosc> oferty = listaOfert.wyswietlOferty(a -> a instanceof Dom && !a.zwrocDateObowiazywania().isBefore(LocalDate.now()));
        for (int i = 0; i < oferty.size(); i++) {
            System.out.println(oferty.get(i).toString());
        }
    }
    private static void opcja4 (ListaOfert listaOfert) {
        System.out.println("Wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań");
        ArrayList<Nieruchomosc> oferty = listaOfert.wyswietlOferty(a -> a instanceof Mieszkanie && !a.zwrocDateObowiazywania().isBefore(LocalDate.now()));
        for (int i = 0; i < oferty.size(); i++) {
            System.out.println(oferty.get(i).toString());
        }
    }
    private static void opcja5 (ListaOfert listaOfert, Scanner scan) {
        System.out.println("Wyświetlenie wszystkich aktualnych ofert sprzedaży domów, w podanej miejscowości o powierzchni nie mniejszej niż podana wartość.");
        System.out.println("Podaj nazwę miejscowości, w której chcesz wyświetlić domy:");
        scan.nextLine();
        String miejscowosc = scan.nextLine();
        System.out.println("Podaj minimalną powierzchnię domu:");
        double powierzchnia = scan.nextDouble();
        ArrayList<Nieruchomosc> oferty = listaOfert.wyswietlOferty(a -> a instanceof Dom && !a.zwrocDateObowiazywania().isBefore(LocalDate.now()) && a.zwrocMiejscowosc().equals(miejscowosc) && a.zwrocPowierzchnie() >= powierzchnia);
        for (int i = 0; i < oferty.size(); i++) {
            System.out.println(oferty.get(i).toString());
        }
    }
    private static void opcja6 (ListaOfert listaOfert, Scanner scan) {
        System.out.println("Wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań, w podanej miejscowości, nie droższych niż podana wartość i od podanego piętra wzwyż.");
        System.out.println("Podaj nazwę miejscowości, w której chcesz wyświetlić mieszkania:");
        scan.nextLine();
        String miejscowosc = scan.nextLine();
        System.out.println("Podaj maksymalną cenę mieszkania:");
        double cena = scan.nextDouble();
        System.out.println("Podaj minimalny numer piętra:");
        int pietro = scan.nextInt();
        ArrayList<Nieruchomosc> oferty = listaOfert.wyswietlOferty(a -> a instanceof Mieszkanie && !a.zwrocDateObowiazywania().isBefore(LocalDate.now()) && a.zwrocMiejscowosc().equals(miejscowosc) && a.zwrocCene() <= cena && ((Mieszkanie) a).zwrocNumerPietra() >= pietro);
        for (int i = 0; i < oferty.size(); i++) {
            System.out.println(oferty.get(i).toString());
        }
    }

    private static void opcja7(ListaOfert listaOfert) {
        System.out.println("Dodano 5 domów i 7 mieszkań do listy ofert.");
        listaOfert.dodajOferteSprzedazyDomu(new Dom("Słowackiego", 15, "Warszawa", "70-134", 140.0, 1000000.00, 300.50, LocalDate.parse("2024-05-28")));
        listaOfert.dodajOferteSprzedazyDomu(new Dom("Mickiewicza", 25, "Kraków", "30-001", 200.5, 850000.00, 500.25, LocalDate.parse("2024-04-15")));
        listaOfert.dodajOferteSprzedazyDomu(new Dom("Kopernika", 10, "Warszawa", "80-001", 180.0, 750000.00, 400.75, LocalDate.parse("2024-07-02")));
        listaOfert.dodajOferteSprzedazyDomu(new Dom("Krakowska", 35, "Gdańsk", "60-001", 160.8, 650000.00, 350.80, LocalDate.parse("2024-06-04")));
        listaOfert.dodajOferteSprzedazyDomu(new Dom("Warszawska", 50, "Gdańsk", "50-001", 220.3, 1200000.00, 600.90, LocalDate.parse("2024-08-10")));
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie("Słowackiego", 15, 10, "Warszawa", "70-134", 140.0, 1,1000000.00, LocalDate.parse("2024-05-28")));
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie("Ruda", 25, 7, "Kraków", "30-001", 80.5, 2,500000.00, LocalDate.parse("2024-06-15")));
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie("Kopernika", 10, 12, "Gdańsk", "80-001", 100.0, 0, 700000.00, LocalDate.parse("2024-07-02")));
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie("Krakowska", 35, 5, "Poznań", "60-001", 65.8, 0, 400000.00, LocalDate.parse("2024-07-20")));
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie("Warszawska", 50, 8, "Warszawa", "50-001", 120.3, 3,900000.00, LocalDate.parse("2024-05-10")));
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie("Grunwaldzka", 20, 6, "Gdańsk", "81-001", 90.2, 2, 600000.00, LocalDate.parse("2024-08-25")));
        listaOfert.dodajOferteSprzedazyMieszkania(new Mieszkanie("Świętojańska", 45, 9, "Poznań", "81-002", 110.6, 1,800000.00, LocalDate.parse("2024-09-05")));

    }
    public static void main(String[] args) {
        menu();
        ListaOfert oferty = new ListaOfert();

        Scanner scan = new Scanner(System.in);
        boolean uruchomiony = true;
        while (uruchomiony) {
            System.out.println("Podaj numer opcji: ");
            int opcja = scan.nextInt();
            switch (opcja) {
                case 1 -> opcja1(oferty, scan);
                case 2 -> opcja2(oferty, scan);
                case 3 -> opcja3(oferty);
                case 4 -> opcja4(oferty);
                case 5 -> opcja5(oferty, scan);
                case 6 -> opcja6(oferty, scan);
                case 7 -> opcja7(oferty);
                case 8 -> uruchomiony = false;
                default -> System.out.println("Musisz podać liczbę: 1 - 8");
            }
        }
    }
}