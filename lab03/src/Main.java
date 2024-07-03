import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("Służę do dodawania ocen studenta i wyświetlania informacji o nich.");
        System.out.println("Mamy do wyboru:");
        System.out.println("1 -> Dodanie nowej oceny");
        System.out.println("2 -> Wyliczenie średniej ocen");
        System.out.println("3 -> Wyświetlenie najwyższej oceny cząstkowej");
        System.out.println("4 -> Wyświetlenie najniższej oceny cząstkowej");
        System.out.println("5 -> Wyjście z programu");
    }
    private static void opcja1(GradeList gradeList, Scanner scan) {
        System.out.println("Wpisz ocenę, którą chcesz dodać:");
        double ocena = scan.nextDouble();
        if (ocena <= 0) {
            System.out.println("Ocena musi mieć wartośc dodatnią.");
        } else {
            gradeList.addGrade(ocena);
            System.out.println("Dodano ocenę "+ocena+" do tablicy.");
        }
    }
    private static void opcja2(GradeList gradeList) {
        double mean = gradeList.calculateMean();
        if (mean == -1) {
            System.out.println("Nie można obliczyć średniej. Tablica jest pusta!");
        } else {
            System.out.println("Średnia ocen wynosi: "+mean);
        }
    }
    private static void opcja3(GradeList gradeList) {
        double najwieksza = gradeList.findHighestGrade();
        if (najwieksza == -1) {
            System.out.println("Nie można wyznaczyć największej wartości. Tablica jest pusta!");
        } else {
            System.out.println("Najwyższa ocena: "+najwieksza);
        }
    }
    private static void opcja4(GradeList gradeList) {
        double najmniejsza = gradeList.findLowestGrade();
        if (najmniejsza == -1) {
            System.out.println("Nie można wyznaczyć najmniejszej wartości. Tablica jest pusta!");
        } else {
            System.out.println("Najniższa ocena: "+najmniejsza);
        }
    }
    public static void main(String[] args) {
        menu();
        GradeList gradeList = new GradeList();
        Scanner scan = new Scanner(System.in);
        boolean uruchomiony = true;
        while (uruchomiony) {
            System.out.println("Podaj numer opcji: ");
            int opcja = scan.nextInt();
            switch (opcja) {
                case 1 -> opcja1(gradeList, scan);
                case 2 -> opcja2(gradeList);
                case 3 -> opcja3(gradeList);
                case 4 -> opcja4(gradeList);
                case 5 -> uruchomiony = false;
                default -> System.out.println("Musisz podać jedną z liczb: 1, 2, 3, 4 lub 5");
            }
        }
    }
}