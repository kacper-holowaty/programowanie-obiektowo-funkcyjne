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
        System.out.println("2 - usunięcie wybranego spotkania z kalendarza");
        System.out.println("3 - wyświetlenie wszystkich spotkań w wybranym dniu");
        System.out.println("4 - wyświetlenie wszystkich spotkań w wybranym dniu o podanym priorytecie");
        System.out.println("5 - wyświetlenie wszystkich spotkań w wybranym dniu zaczynających się nie wcześniej niż wybrana godzina");
        System.out.println("6 - wyświetlenie wszystkich spotkań w wybranym dniu odbywających się pomiedzy podanymi czasami włącznie");
        System.out.println("7 - wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie zaczynających się nie wcześniej niż wybrana godzina");
        System.out.println("8 - dodanie 7 spotkań na raz na wtorek (dzień numer 2)");
        System.out.println("9 - zakończenie działania programu\n");
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
                        kalendarz.dodajSpotkanie(dzienTygodnia, new Spotkanie(opis, godzinaSpotkania, godzinaZakonczenia, priorytet));
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
    private static void opcja2 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wpisz numer dnia tygodnia, z którego chcesz usunąć spotkanie:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Indeksy odpowiadają danym spotkaniom:");
            ArrayList<Spotkanie> spotkania = kalendarz.wyswietlSpotkania(dzienTygodnia, t -> true);
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(i+" -> "+spotkania.get(i).toString());
            }
            System.out.println("Wpisz index elementu do usuniecia:");
            int id = scan.nextInt();
            kalendarz.usunSpotkanie(dzienTygodnia, id);
        }
    }
    private static void opcja3 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            ArrayList<Spotkanie> spotkania = kalendarz.wyswietlSpotkania(dzienTygodnia, t -> true);
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(spotkania.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja4 (Kalendarz kalendarz, Scanner scan) {
        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        scan.nextLine();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Wpisz priorytet spotkania:");
            String priorytet = scan.nextLine();
            ArrayList<Spotkanie> spotkania = kalendarz.wyswietlSpotkania(dzienTygodnia, a -> a.zwrocPriorytet().equals(priorytet));
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(spotkania.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja5 (Kalendarz kalendarz, Scanner scan) {

        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute = scan.nextInt();
            LocalTime godzinaSpotkania = LocalTime.of(hour, minute);
            ArrayList<Spotkanie> spotkania = kalendarz.wyswietlSpotkania(dzienTygodnia, a -> !a.zwrocCzasRozpoczecia().isBefore(godzinaSpotkania));
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(spotkania.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja6 (Kalendarz kalendarz, Scanner scan) {

        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Podaj czas, od którego będziemy wyznaczać przedzał.");
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute = scan.nextInt();
            LocalTime godzinaRozpoczeciaSpotkania = LocalTime.of(hour, minute);
            System.out.println("Podaj czas, do którego będziemy wyznaczać przedzał.");
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour2 = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute2 = scan.nextInt();
            LocalTime godzinaZakonczeniaSpotkania = LocalTime.of(hour2, minute2);
            ArrayList<Spotkanie> spotkania = kalendarz.wyswietlSpotkania(dzienTygodnia, a -> !a.zwrocCzasRozpoczecia().isBefore(godzinaRozpoczeciaSpotkania) && !a.zwrocCzasZakonczenia().isAfter(godzinaZakonczeniaSpotkania));
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(spotkania.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }

    private static void opcja7 (Kalendarz kalendarz, Scanner scan) {

        System.out.println("Wpisz numer dnia tygodnia dla którego chcesz wyświetlić spotkania:");
        int dzienTygodnia = scan.nextInt();
        if (dzienTygodnia>=1 && dzienTygodnia < 8) {
            System.out.println("Podaj liczbę godzin (np. 10):");
            int hour = scan.nextInt();
            System.out.println("Podaj liczbę minut (np. 45):");
            int minute = scan.nextInt();
            scan.nextLine();
            LocalTime godzinaSpotkania = LocalTime.of(hour, minute);
            System.out.println("Wpisz priorytet spotkania:");
            String priorytet = scan.nextLine();
            ArrayList<Spotkanie> spotkania = kalendarz.wyswietlSpotkania(dzienTygodnia, a -> !a.zwrocCzasRozpoczecia().isBefore(godzinaSpotkania) && a.zwrocPriorytet().equals(priorytet));
            for (int i = 0; i < spotkania.size(); i++) {
                System.out.println(spotkania.get(i).toString());
            }
        }
        else {
            System.out.println("Niepoprawny dzień tygodnia.");
        }
    }
    private static void opcja8(Kalendarz kalendarz) {
        kalendarz.dodajSpotkanie(2, new Spotkanie("Ważne spotkanie z klientem", LocalTime.of(10, 45), LocalTime.of(12, 15), "wysoki"));
        kalendarz.dodajSpotkanie(2, new Spotkanie("Prezentacja nowego projektu", LocalTime.of(9, 0), LocalTime.of(10, 30), "normalny"));
        kalendarz.dodajSpotkanie(2, new Spotkanie("Konferencja prasowa", LocalTime.of(14, 0), LocalTime.of(15, 30), "najwyższy"));
        kalendarz.dodajSpotkanie(2, new Spotkanie("Zebranie z zespołem", LocalTime.of(16, 30), LocalTime.of(18, 0), "normalny"));
        kalendarz.dodajSpotkanie(2, new Spotkanie("Prezentacja wyników badań", LocalTime.of(11, 30), LocalTime.of(13, 0), "wysoki"));
        kalendarz.dodajSpotkanie(2, new Spotkanie("Szkolenie z nowego oprogramowania", LocalTime.of(8, 0), LocalTime.of(9, 30), "najwyższy"));
        kalendarz.dodajSpotkanie(2, new Spotkanie("Rozmowa kwalifikacyjna", LocalTime.of(15, 0), LocalTime.of(16, 30), "normalny"));
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
                case 8 -> opcja8(kalendarz);
                case 9 -> uruchomiony = false;
                default -> System.out.println("Musisz podać liczbę: 1, 2, 3, 4, 5, 6 lub 7.");
            }
        }
    }
}