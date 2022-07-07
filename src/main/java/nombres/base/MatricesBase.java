package nombres.base;

import visualiser.Visu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;

public class MatricesBase extends ArrayList<MatricesBase.Paire> {

    int N = 128;
    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres" +
            "\\src\\main\\java\\nombres\\base\\";


    public MatricesBase() throws IOException {
        int[][] f = f();
       // matriceToTextFile(f, chemin, "f_", N);
        int[] valeurs = IntStream.of(to1Dtab(f)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(valeurs));
        new Visu(f, N,valeurs);
    }

    public static void main(String[] args) throws IOException {
        new MatricesBase();
    }

    int[][] f() {
        int[][] mat = new int[N + 1][N + 1];
        range(1, N).forEach(i -> range(1, N).forEach(j -> add(new Paire(i, j))));
        forEach(p -> forEach(q -> {
            // if (p.i <= p.j)
            if (p.i * p.j == q.i * q.j) mat[p.i][p.j]++;
        }));
        return mat;
    }

    int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[(int) pow(N+1,2)];
        range(0, N+1).forEach(i -> arraycopy(tab2D[i], 0, tab1D, i * (N+1),N+1));
        return tab1D;
    }

    public record Paire(Integer i, Integer j) {
    }
}

