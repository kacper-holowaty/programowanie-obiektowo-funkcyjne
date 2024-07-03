import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean czyUruchomiony = true;
        while(czyUruchomiony) {
            System.out.println("Służę do wyświetlania silni.");
            Scanner scan = new Scanner(System.in);

            System.out.println("Podaj liczbę, dla której obliczamy silnię:");
            int n = scan.nextInt();
            long wartoscSilnia = silnia(n);
            System.out.println("Silnia dla liczby: "+n+" wynosi: "+wartoscSilnia);
            System.out.println("Czy chcesz zakończyć program (tak/nie):");
            String czyZakonczyc = scan.next();

            if (czyZakonczyc.equals("tak")) {
                czyUruchomiony = false;
            }
        }
    }
    public static long silnia(int n) {
        long silnia = 1;
        for (int i = 1; i <= n; i++) {
            silnia *= i;
        }
        return silnia;
    }
}
