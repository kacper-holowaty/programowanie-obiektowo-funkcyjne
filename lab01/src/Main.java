import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean czyUruchomiony = true;
        Scanner scan = new Scanner(System.in);
        while(czyUruchomiony) {
            System.out.println("Wybierz jaki program chcesz uruchomić, wpisz: 'silnia' albo 'suma':");
            String opcja = scan.next();
            switch (opcja) {
                case "silnia" -> {
                    System.out.println("Służę do wyświetlania silni.");
                    System.out.println("Podaj liczbę, dla której obliczamy silnię:");
                    int n = scan.nextInt();
                    long wartoscSilnia = Obliczenia.silnia(n);
                    System.out.println("Silnia dla liczby: "+n+" wynosi: "+wartoscSilnia);
                }
                case "suma" -> {
                    System.out.println("Obliczamy sumę wszystkich liczb w przedziale od a do b");
                    System.out.println("Podaj pierwszą liczbę (początek przedziału): ");
                    int a = scan.nextInt();
                    System.out.println("Podaj drugą liczbę (koniec przedziału): ");
                    int b = scan.nextInt();
                    long wynikSuma = Obliczenia.suma(a, b);
                    System.out.println("Suma liczb w przedziale od "+a+" do "+b+" wynosi: "+wynikSuma);
                }
                default -> System.out.println("Musisz wpisać 'silnia' albo 'suma'.");
            }
            System.out.println("Czy chcesz kontynuować program (tak/nie):");
            String czyKontynuowac = scan.next();
            if (czyKontynuowac.equals("nie")) {
                czyUruchomiony = false;
            }
        }
    }
}
