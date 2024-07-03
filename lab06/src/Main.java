import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("Służę do obsługi kalendarza tygodniowego spotkań.");
        System.out.println("Dla następujących dni tygodnia mamy:\n1 - poniedziałek\n2 - wtorek\n3 - środa");
        System.out.println("4 - czwartek\n5 - piątek\n6 - sobota\n7 - niedziela\n");
        System.out.println("Mamy następujące opcje uruchomienia programu:");
        System.out.println("1 - dodanie spotkania do kalendarza");
        System.out.println("2 - dodanie zadania do kalendarza");
        System.out.println("3 - usunięcie wybranego spotkania z kalendarza");
        System.out.println("4 - usunięcie wybranego zadania z kalendarza");
        System.out.println("5 - wyświetlenie wszystkich spotkań w wybranym dniu");
        System.out.println("6 - wyświetlenie wszystkich zadań w wybranym dniu");
        System.out.println("7 - wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie");
        System.out.println("8 - wyświetlenie wszystkich zadań w wybranym dniu o wybranym statusie");
        System.out.println("9 - wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie, zaczynających się nie wcześniej niż wybrana godzina");
        System.out.println("10 - wyświetlenie wszystkich zadań w wybranym dniu o wybranym statusie, kończących się nie później niż wybrana godzina");
        System.out.println("11 - dodanie 14 spotkań i zadań na raz na wtorek (dzień numer 2)");
        System.out.println("12 - zakończenie działania programu\n");
    }
    private static void opcja1(Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wpisz numer dnia tygodnia, w którym chcesz dodać spotkanie:");
        int dzienTygodnia = scan.nextInt();
        scan.nextLine();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Dodaj opis spotkania:");
            String opis = scan.nextLine();
            System.out.println("O której rozpocznie się spotkanie?");
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute = scan.nextInt();
            LocalTime godzinaSpotkania = LocalTime.of(hour, minute);
            if (godzinaSpotkania.isBefore(Spotkanie.NAJWCZESNIEJSZA_GODZINA)) {
                System.out.println("Spotkanie nie może rozpocząć się wcześniej niż "+Spotkanie.NAJWCZESNIEJSZA_GODZINA);
            } else {
                System.out.println("O której zakończy się spotkanie?");
                System.out.println("Podaj liczbę godzin (np. 10):");
                int endHour = scan.nextInt();
                System.out.println("Podaj liczbę minut (np. 45):");
                int endMinute = scan.nextInt();
                scan.nextLine();
                LocalTime godzinaZakonczenia = LocalTime.of(endHour, endMinute);
                if (godzinaZakonczenia.isAfter(godzinaSpotkania)) {
                    System.out.println("Podaj priorytet spotkania (normalny, wysoki, najwyższy");
                    String priorytet = scan.nextLine();
                    if (priorytet.equals("normalny") || priorytet.equals("wysoki") || priorytet.equals("najwyższy")) {
                        kalendarz.dodajWydarzenie(dzienTygodnia, new Spotkanie(opis, godzinaSpotkania, godzinaZakonczenia, priorytet));
                        System.out.println("Utworzono i dodano spotkanie do kalendarza.");
                    } else {
                        System.out.println("Niepoprawny priorytet spotkania.");
                    }
                } else {
                    System.out.println("Spotkanie musi zakończyć się później, niż się rozpoczęło.");
                }
            }
        } else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja2(Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wpisz numer dnia tygodnia, do którego chcesz dodać zadanie:");
        int dzienTygodnia = scan.nextInt();
        scan.nextLine();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Dodaj opis zadania:");
            String opis = scan.nextLine();
            System.out.println("O której godzinie rozpocznie się zadanie?");
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute = scan.nextInt();
            LocalTime godzinaSpotkania = LocalTime.of(hour, minute);
            if (godzinaSpotkania.isBefore(Spotkanie.NAJWCZESNIEJSZA_GODZINA)) {
                System.out.println("Zadanie nie może rozpocząć się wcześniej niż "+Spotkanie.NAJWCZESNIEJSZA_GODZINA);
            } else {
                System.out.println("O której zakończy się zadanie?");
                System.out.println("Podaj liczbę godzin (np. 10):");
                int endHour = scan.nextInt();
                System.out.println("Podaj liczbę minut (np. 45):");
                int endMinute = scan.nextInt();
                scan.nextLine();
                LocalTime godzinaZakonczenia = LocalTime.of(endHour, endMinute);
                if (godzinaZakonczenia.isAfter(godzinaSpotkania)) {
                    System.out.println("Podaj status zadania (planowane, potwierdzone, realizowane, wykonane)");
                    String priorytet = scan.nextLine();
                    if (priorytet.equals("planowane") || priorytet.equals("potwierdzone") || priorytet.equals("realizowane") | priorytet.equals("wykonane")) {
                        kalendarz.dodajWydarzenie(dzienTygodnia, new Spotkanie(opis, godzinaSpotkania, godzinaZakonczenia, priorytet));
                        System.out.println("Utworzono i dodano zadanie do kalendarza.");
                    } else {
                        System.out.println("Niepoprawny status zadania.");
                    }
                } else {
                    System.out.println("Zadanie musi zakończyć się później, niż się rozpoczęło.");
                }
            }
        } else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja3 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wpisz numer dnia tygodnia, z którego chcesz usunąć spotkanie:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Indeksy odpowiadają danym spotkaniom:");
            ArrayList<Wydarzenie> wydarzenia = kalendarz.wyswietlWydarzenia(dzienTygodnia, event -> event instanceof Spotkanie);
            for (int i = 0; i < wydarzenia.size(); i++) {
                System.out.println(i+" -> "+wydarzenia.get(i).toString());
            }
            System.out.println("Wpisz index elementu do usunięcia:");
            int id = scan.nextInt();
            kalendarz.usunSpotkanie(dzienTygodnia, id);
        }
    }
    private static void opcja4 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wpisz numer dnia tygodnia, z którego chcesz usunąć zadanie:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Indeksy odpowiadają danym spotkaniom:");
            ArrayList<Wydarzenie> wydarzenia = kalendarz.wyswietlWydarzenia(dzienTygodnia, event -> event instanceof Zadanie);
            for (int i = 0; i < wydarzenia.size(); i++) {
                System.out.println(i+" -> "+wydarzenia.get(i).toString());
            }
            System.out.println("Wpisz index elementu do usunięcia:");
            int id = scan.nextInt();
            kalendarz.usunZadanie(dzienTygodnia, id);
        }
    }
    private static void opcja5 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wyświelenie spotkań w wybranym dniu.");
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            ArrayList<Wydarzenie> spotkania = kalendarz.wyswietlWydarzenia(dzienTygodnia, event -> event instanceof Spotkanie);
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(spotkania.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja6 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wyświelenie zadań w wybranym dniu.");
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić zadania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            ArrayList<Wydarzenie> spotkania = kalendarz.wyswietlWydarzenia(dzienTygodnia, event -> event instanceof Zadanie);
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(spotkania.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja7 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wyświelenie spotkań w wybranym dniu o wybranym priorytecie.");
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        scan.nextLine();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Wpisz priorytet spotkania:");
            String priorytet = scan.nextLine();
            ArrayList<Wydarzenie> wydarzenia = kalendarz.wyswietlWydarzenia(dzienTygodnia, a -> a instanceof Spotkanie && a.zwrocPriorytetAlboStatus().equals(priorytet));
            for (int i = 0; i < wydarzenia.size(); i++) {
                System.out.println(wydarzenia.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja8 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wyświelenie zadań w wybranym dniu o wybranym statusie.");
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić zadania:");
        int dzienTygodnia = scan.nextInt();
        scan.nextLine();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Wpisz status zadania");
            String status= scan.nextLine();
            ArrayList<Wydarzenie> wydarzenia = kalendarz.wyswietlWydarzenia(dzienTygodnia, a -> a instanceof Zadanie && a.zwrocPriorytetAlboStatus().equals(status));
            for (int i = 0; i < wydarzenia.size(); i++) {
                System.out.println(wydarzenia.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja9 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie, zaczynających się nie wcześniej niż od podanego czasu.");
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute = scan.nextInt();
            LocalTime godzinaSpotkania = LocalTime.of(hour, minute);
            ArrayList<Wydarzenie> wydarzenia = kalendarz.wyswietlWydarzenia(dzienTygodnia, a -> a instanceof Spotkanie && !a.zwrocCzasRozpoczecia().isBefore(godzinaSpotkania));
            for (int i = 0; i < wydarzenia.size(); i++) {
                System.out.println(wydarzenia.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja10 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wyświetlenie wszystkich zadań w wybranym dniu o wybranym statusie, kończących się nie później niż od podanego czasu.");
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute = scan.nextInt();
            LocalTime godzinaZakonczenia = LocalTime.of(hour, minute);
            ArrayList<Wydarzenie> wydarzenia = kalendarz.wyswietlWydarzenia(dzienTygodnia, a -> a instanceof Zadanie && !a.zwrocCzasZakonczenia().isAfter(godzinaZakonczenia));
            for (int i = 0; i < wydarzenia.size(); i++) {
                System.out.println(wydarzenia.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja11(Kalendarz kalendarz) {
        System.out.println("Dodano 7 spotkań i 7 zadań na wtorek.");
        kalendarz.dodajWydarzenie(2, new Spotkanie("Ważne spotkanie z klientem", LocalTime.of(10, 45), LocalTime.of(12, 15), "wysoki"));
        kalendarz.dodajWydarzenie(2, new Spotkanie("Prezentacja nowego projektu", LocalTime.of(9, 0), LocalTime.of(10, 30), "normalny"));
        kalendarz.dodajWydarzenie(2, new Spotkanie("Konferencja prasowa", LocalTime.of(14, 0), LocalTime.of(15, 30), "najwyższy"));
        kalendarz.dodajWydarzenie(2, new Spotkanie("Zebranie z zespołem", LocalTime.of(16, 30), LocalTime.of(18, 0), "normalny"));
        kalendarz.dodajWydarzenie(2, new Spotkanie("Prezentacja wyników badań", LocalTime.of(11, 30), LocalTime.of(13, 0), "wysoki"));
        kalendarz.dodajWydarzenie(2, new Spotkanie("Szkolenie z nowego oprogramowania", LocalTime.of(8, 0), LocalTime.of(9, 30), "najwyższy"));
        kalendarz.dodajWydarzenie(2, new Spotkanie("Rozmowa kwalifikacyjna", LocalTime.of(15, 0), LocalTime.of(16, 30), "normalny"));
        kalendarz.dodajWydarzenie(2, new Zadanie("Przygotowanie prezentacji", LocalTime.of(9, 0), LocalTime.of(10, 30), "planowane"));
        kalendarz.dodajWydarzenie(2, new Zadanie("Spotkanie zespołu projektowego", LocalTime.of(11, 0), LocalTime.of(12, 0), "potwierdzone"));
        kalendarz.dodajWydarzenie(2, new Zadanie("Lunch z klientem", LocalTime.of(13, 0), LocalTime.of(14, 0), "realizowane"));
        kalendarz.dodajWydarzenie(2, new Zadanie("Analiza danych sprzedażowych", LocalTime.of(14, 30), LocalTime.of(16, 0), "wykonane"));
        kalendarz.dodajWydarzenie(2, new Zadanie("Warsztaty online", LocalTime.of(16, 30), LocalTime.of(18, 0), "planowane"));
        kalendarz.dodajWydarzenie(2, new Zadanie("Telefon do dostawcy", LocalTime.of(9, 30), LocalTime.of(10, 0), "potwierdzone"));
        kalendarz.dodajWydarzenie(2, new Zadanie("Raport miesięczny", LocalTime.of(17, 0), LocalTime.of(18, 30), "wykonane"));
    }
    public static void main(String[] args) {
        menu();
        Kalendarz kalendarz = new Kalendarz();

        Scanner scan = new Scanner(System.in);
        boolean uruchomiony = true;
        while (uruchomiony) {
            System.out.println("Podaj numer opcji: ");
            int opcja = scan.nextInt();
            switch (opcja) {
                case 1 -> opcja1(kalendarz, scan);
                case 2 -> opcja2(kalendarz, scan);
                case 3 -> opcja3(kalendarz, scan);
                case 4 -> opcja4(kalendarz, scan);
                case 5 -> opcja5(kalendarz, scan);
                case 6 -> opcja6(kalendarz, scan);
                case 7 -> opcja7(kalendarz, scan);
                case 8 -> opcja8(kalendarz, scan);
                case 9 -> opcja9(kalendarz, scan);
                case 10 -> opcja10(kalendarz, scan);
                case 11 -> opcja11(kalendarz);
                case 12 -> uruchomiony = false;
                default -> System.out.println("Musisz podać liczbę: 1 - 12");
            }
        }
    }
}