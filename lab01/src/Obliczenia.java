public class Obliczenia {
    public static long silnia(int n) {
        long silnia = 1;
        for (int i = 1; i <= n; i++) {
            silnia *= i;
        }
        return silnia;
    }

    public static long suma(int a, int b) {
        long suma = 0;
        for (int i = a; i <= b; i++) {
            suma += i;
        }
        return suma;
    }
}
