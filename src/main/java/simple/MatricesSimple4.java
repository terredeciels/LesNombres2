package simple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;
import static nombres.MatriceToTextFile.matriceToTextFile;
import static simple.MatricesSimple4.Paire;

public class MatricesSimple4 extends ArrayList<Paire> {

    private final int N = 128;
    private final int M = N + 1;
    private final int[][] tab = new int[M][M];

    //  String chemin = "/home/tdc/IdeaProjects/LesNombres2/src/main/java/simple/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres2" +
            "\\src\\main\\java\\simple\\";

    private MatricesSimple4() throws IOException {
        int[][] f = f();
        int[] valeurs = IntStream.of(to1Dtab(f)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(valeurs));

        matriceToTextFile(f, chemin, "f4__", N);
    }

    public static void main(String[] args) throws IOException {
        new MatricesSimple4();
    }

    private int[][] f() {
        for (int i = 1; i < M; i++) for (int j = 1; j < M; j++) add(new Paire(i, j));
        for (Paire p : this) for (Paire q : this) if (p.i * p.j == q.i * q.j) tab[p.i][p.j]++;
        return tab;
    }

    private int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[M * M];
        range(1, M).forEach(i -> arraycopy(tab2D[i], 0, tab1D, i * M, M));
        return tab1D;
    }

    record Paire(int i, int j) {
    }
}

