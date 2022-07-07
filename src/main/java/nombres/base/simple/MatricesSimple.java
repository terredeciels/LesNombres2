package nombres.base.simple;

import java.io.IOException;
import java.util.ArrayList;

import static nombres.MatriceToTextFile.matriceToTextFile;

public class MatricesSimple extends ArrayList<MatricesSimple.Paire> {

    int N = 512;
    //    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres" +
//            "\\src\\main\\java\\nombres\\base\\";
    String chemin = "/home/tdc/IdeaProjects/LesNombres2/src/main/java/nombres/base/simple/";

    public MatricesSimple() throws IOException {
        int[][] f = f();
        matriceToTextFile(f, chemin, "f_", N);
    }

    public static void main(String[] args) throws IOException {
        new MatricesSimple();
    }

    int[][] f() {
        int[][] tab = new int[N + 1][N + 1];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                add(new Paire(i, j));
            }
        }
        for (Paire p : this) {
            for (Paire q : this) {
                // if (p.i <= p.j)
                if (p.i * p.j == q.i * q.j) tab[p.i][p.j]++;
            }
        }
        return tab;
    }

    public record Paire(Integer i, Integer j) {
    }
}

