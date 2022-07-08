package nombres.base.simple;

import java.io.IOException;
import java.util.ArrayList;

import static nombres.MatriceToTextFile.matriceToTextFile;

public class MatricesSimple2 extends ArrayList<MatricesSimple2.Paire> {

    private final int N = 128;
      int a = 2;
    private final int[][] tab = new int[N + 1][N + 1];
    private final int[][] rho = new int[N + 1][N + 1];
    String chemin = "/home/tdc/IdeaProjects/LesNombres2/src/main/java/nombres/base/simple/";

   private int[][] frho() {
        for (int d = 1; d <= N; d += a) {
            for (int k = 1; k <= N; k += a) {
                for (int L = k; L < k + a; L++) {
                    for (int l = k; l < k + a; l++) {
                        rho[d][k] += tab[L][l];
                    }
                }
            }
        }
        return rho;
    }

    public MatricesSimple2() throws IOException {
        matriceToTextFile(f(), chemin, "f_", N);
        matriceToTextFile(frho(), chemin, "rho_", N);
    }

    public static void main(String[] args) throws IOException {
        new MatricesSimple2();
    }

    private int[][] f() {
        for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) add(new Paire(i, j));
        for (Paire p : this) for (Paire q : this) if (p.i * p.j == q.i * q.j) tab[p.i][p.j]++;
        return tab;
    }

    public record Paire(Integer i, Integer j) {
    }
}

