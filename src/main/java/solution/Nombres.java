package solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;
import static solution.MatriceToTextFile.matriceToTextFile;

public class Nombres {

    private final int N = 128;
    private final int M = N + 1;
    private final int[][] tab = new int[M][M];
    private final List<Paire>[][] ltab = new ArrayList[M][M];
    private final List<Paire> X = new ArrayList<>();
    private final List<Integer> P = new ArrayList<>();
    //  String chemin = "/home/tdc/IdeaProjects/LesNombres2/src/main/java/simple/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres2" +
            "\\src\\main\\java\\solution\\";

    {
        for (int i = 1; i < M; i++)
            for (int j = 1; j < M; j++)
                ltab[i][j] = new ArrayList<>();
    }


    private Nombres() throws IOException {
        List<Paire>[][] ltab = ltab();
        int[][] tab = tab();
        int[] valeurs = IntStream.of(to1Dtab(tab)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(valeurs));

        matriceToTextFile(tab, chemin, "tab_", N);

        for (int val : valeurs) {

        }
    }

    public static void main(String[] args) throws IOException {
        new Nombres();
    }

    private int[][] tab() {
        for (int i = 1; i < M; i++)
            for (int j = 1; j < M; j++)
                tab[i][j] = ltab[i][j].size();
        return tab;
    }

    private List<Paire>[][] ltab() {
        for (int i = 1; i < M; i++) for (int j = 1; j < M; j++) X.add(new Paire(i, j));
        for (Paire p : X) P.add(p.i * p.j);
        for (Paire p : X)
            for (int x : P)
                if (p.i * p.j == x) ltab[p.i][p.j].add(new Paire(p.i, p.j));
        return ltab;
    }

    private int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[M * M];
        range(1, M).forEach(i -> arraycopy(tab2D[i], 0, tab1D, i * M, M));
        return tab1D;
    }

    record Paire(int i, int j) {
    }
}

