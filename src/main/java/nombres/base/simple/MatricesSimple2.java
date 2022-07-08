package nombres.base.simple;

import visualiser.Visu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;
import static nombres.MatriceToTextFile.matriceToTextFile;

public class MatricesSimple2 extends ArrayList<MatricesSimple2.Paire> {

    private final int N = 128;
    private final int[][] tab = new int[N + 1][N + 1];
    private final int[][] rho = new int[N + 1][N + 1];
      double[][] frhoDouble= new double[N + 1][N + 1];
    //int count;
    int a = 2;
    //  String chemin = "/home/tdc/IdeaProjects/LesNombres2/src/main/java/nombres/base/simple/";
    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres2" +
            "\\src\\main\\java\\nombres\\base\\simple\\";

    public MatricesSimple2() throws IOException {

        int[][] f = f();
        int[][] frho = frho();
        int[] valeurs = IntStream.of(to1Dtab(frho)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(valeurs));
        double max = IntStream.of(to1Dtab(frho)).max().getAsInt()+0.0;

        for (int d = 1; d <= N; d ++) {
            for (int k = 1; k <= N; k ++) {
                frhoDouble[d][k]= frho[d][k]/max;
            }
        }

        matriceToTextFile(f, chemin, "f_", N);
        matriceToTextFile(frho, chemin, "rho_" + a + "_", N);
        matriceToTextFile(frhoDouble, chemin, "rho_" + a + "_Double_", N);
      //
        new Visu(frho, N);
    }

    public static void main(String[] args) throws IOException {
        new MatricesSimple2();
    }

    private int[][] frho() {
        for (int d = 1; d <= N; d += a) {
            for (int k = 1; k <= N; k += a) {
                for (int L = d; L < d + a; L++) {
                    for (int l = k; l < k + a; l++) {
                        rho[d][k] += tab[L][l];
                    }
                }
            }
        }
        return rho;
    }

    private int[][] f() {
        for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) add(new Paire(i, j));
        for (Paire p : this) for (Paire q : this) if (p.i * p.j == q.i * q.j) tab[p.i][p.j]++;
        return tab;
    }
    int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[(int) pow(tab2D.length,2)];
        range(1, tab2D.length).forEach(i -> arraycopy(tab2D[i],
                0, tab1D, i * tab2D.length,tab2D.length));
        return tab1D;
    }
    public record Paire(Integer i, Integer j) {
    }
}

