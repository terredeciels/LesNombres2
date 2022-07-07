package nombres;

import java.util.ArrayList;

import static java.util.stream.IntStream.range;

public class PrimeFactors extends ArrayList<Integer> {

    public PrimeFactors(int entier) {
        int n = entier;
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                add(i);
                n /= i;
            }
        }
        if (n > 1) {
            add(n);
        }
    }

    public static boolean estPremier(int n) {
        PrimeFactors primeFactors = new PrimeFactors(n);
        return primeFactors.contains(n) && primeFactors.size() == 1;
    }

    public static int[][] premiers(int N) {
        int[][] tab = new int[N + 1][N + 1];
        range(1, N).forEach(i -> range(1, N).forEach(j -> {

            tab[i][j] = estPremier(i) && estPremier(j) ? 1 : 0;
        }));
        return tab;
    }

    public static void main(String[] args) {
        System.out.println(new PrimeFactors(38));
        System.out.println(estPremier(38));
    }
}


