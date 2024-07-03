import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("Służę do wylicznia różnych informacji na temat walca.");
        System.out.println("Mamy do wyboru:");
        System.out.println("1 -> Wyświetlanie wartości zmiennych instancji obiektu klasy Walec");
        System.out.println("2 -> Ustawienie wartości zmiennych instancji obiektu klasy Walec");
        System.out.println("3 -> Wyliczenie i wyświetlenie pól powierzchni obiektu klasy Walec");
        System.out.println("4 -> Wyliczenie i wyświetlenie objętości obiektu klasy Walec");
        System.out.println("5 -> Wyjście z programu");
    }
    private static void opcja1(Walec walec) {
        double h = walec.odczytajWysokosc();
        double r = walec.odczytajPromien();
        System.out.println("Walec ma promień długości: " + r + " i ma wysokość: " + h);
    }
    private static void opcja2(Walec walec, Scanner scan) {
        System.out.println("Podaj długość promienia:");
        double promien = scan.nextDouble();
        System.out.println("Podaj wysokość walca:");
        double wysokosc = scan.nextDouble();
        walec.ustawPromien(promien);
        walec.ustawWysokosc(wysokosc);
    }
    private static void opcja3(Walec walec) {
        System.out.println("Pole powierzchni podstawy: " + walec.obliczPPP());
        System.out.println("Pole powierzchni bocznej: " + walec.obliczPPB());
        System.out.println("Pole powierzchni całkowitej: " + walec.obliczPPC());
    }

    public static void main(String[] args) {
        menu();
        // Walec walec = new Walec(4.0, 3.5)
        Walec walec = new Walec();
        Scanner scan = new Scanner(System.in);
        boolean uruchomiony = true;
        while (uruchomiony) {
            System.out.println("Podaj numer opcji: ");
            int opcja = scan.nextInt();
            switch (opcja) {
                case 1 -> opcja1(walec);
                case 2 -> opcja2(walec, scan);
                case 3 -> opcja3(walec);
                case 4 -> System.out.println("Objętość walca: " + walec.objetosc());
                case 5 -> uruchomiony = false;
                default -> System.out.println("Musisz podać jedną z liczb: 1, 2, 3, 4 lub 5.");
            }
        }
    }
}