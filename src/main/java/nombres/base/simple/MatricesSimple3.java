package nombres.base.simple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;
import static nombres.FonctionToTextFile.fonctionToTextFile;
import static nombres.MatriceToTextFile.matriceToTextFile;

public class MatricesSimple3 extends ArrayList<MatricesSimple3.Paire> {

    private final int N = 512;
    private final int[][] tab = new int[N + 1][N + 1];

    //  String chemin = "/home/tdc/IdeaProjects/LesNombres2/src/main/java/nombres/base/simple/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres2" +
            "\\src\\main\\java\\nombres\\base\\simple\\";

    public MatricesSimple3() throws IOException {
        int[][] f = f();
        int[] valeurs = IntStream.of(to1Dtab(f)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(valeurs));
        Map<Integer, Integer> f1 = new HashMap<>();
        for (int val : valeurs) {
            int count = 0;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (f[i][j] == val) count++;
                }
            }
            f1.put(val, count);
        }
        matriceToTextFile(f, chemin, "f_", N);
        fonctionToTextFile(f1, chemin, "F1D_", N);
    }

    public static void main(String[] args) throws IOException {
        new MatricesSimple3();
    }

    private int[][] f() {
        for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) add(new Paire(i, j));
        for (Paire p : this) for (Paire q : this) if (p.i * p.j == q.i * q.j) tab[p.i][p.j]++;
        return tab;
    }

    int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[(int) pow(tab2D.length, 2)];
        range(1, tab2D.length).forEach(i -> arraycopy(tab2D[i],
                0, tab1D, i * tab2D.length, tab2D.length));
        return tab1D;
    }

    public record Paire(Integer i, Integer j) {
    }
}

