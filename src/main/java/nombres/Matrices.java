package nombres;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.arraycopy;
import static java.util.stream.IntStream.range;
import static nombres.MatriceToTextFile.matriceToTextFile;

public class Matrices extends ArrayList<Matrices.Paire> {

    int N = 32;
    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres" +
            "\\src\\main\\java\\nombres\\";

    {
        range(0, N).forEach(n -> {
                    assert (nbOfDiv(n) == d(n));
                }
        );
        range(1, N).forEach(i -> range(1, N).forEach(j -> {
            assert (f()[i][j] == d()[i][j]);
            assert (f()[i][j] == nbOfDiv()[i][j]);
        }));

    }

    public Matrices() throws IOException {
//        matriceToTextFile(dd(), chemin, "dd", N);

        int[][] f = f();
        matriceToTextFile(f, chemin, "f_", N);
        // System.exit(0);
        int[] valeurs = IntStream.of(to1Dtab(f)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(valeurs));

        List<int[][]> g = new ArrayList<>();
        final int[][][] gtemp = new int[1][1][1];
        range(0, valeurs.length)
                .forEach(k -> {
                            gtemp[0] = new int[N + 1][N + 1];
                            range(1, N)
                                    .forEach(i -> range(1, N)
                                            .forEach(j -> gtemp[0][i][j] = f[i][j] == valeurs[k] ? 1 : 0

                                            ));
                            g.add(k, gtemp[0]);

                        }
                );

        range(0, valeurs.length)
                .forEach(k -> {
                    try {
                        matriceToTextFile(g.get(k), chemin, "g_" + valeurs[k] + "_", N);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

//        final double[] count = {0};
//        range(1, N).forEach(i -> range(1, N).forEach(j -> {
//            if (g[i][j] == 1) count[0]++;
//        }));
//        System.out.println(count[0] / (N * N));
        // new Visu(g, N);


//        M G = new M(N, f);
//        int i=8,j=8,k=24,l=24;
//        int[][] sG = G.extract(i, j, k, l);
//        new Visu(sG, 8);


        // int[][] h = new int[N + 1][N + 1];
        // int[][] dd = dd();
//        range(1, N).forEach(i -> range(1, N).forEach(j -> h[i][j] = d(i)*d(j) == d(i*j) ? 1 : 0));
//        matriceToTextFile(h, chemin, "h", N);

        // matriceToTextFile(premiers(128),chemin,"P_",128);
        // new Visu(f, N,valeurs);

    }

    public static void main(String[] args) throws IOException {
        new Matrices();
    }

    public static int[] to1Dtab(int[][] tab2D) {
        int[] tab1D = new int[tab2D.length * tab2D.length];
        range(0, tab2D.length)
                .forEach(i -> arraycopy(tab2D[i], 0, tab1D, (i * tab2D.length), tab2D.length));
        return tab1D;
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

    int d(int n) {
        final int[] nbdiv = {0};
        range(1, N).forEach(i -> range(1, N).forEach(j -> {
            if (i * j == n) nbdiv[0]++;
        }));
        return nbdiv[0];
    }

    int[][] dd() {
        int[][] mat = new int[N + 1][N + 1];
        range(1, N).forEach(i -> range(1, N).forEach(j -> mat[i][j] = d(i) * d(j)));
        return mat;
    }

    int[][] d() {
        int[][] mat = new int[N + 1][N + 1];
        range(1, N).forEach(i -> range(1, N).forEach(j -> mat[i][j] = d(i * j)));
        return mat;
    }

    int nbOfDiv(int n) {
        return (int) range(1, n + 1).filter(i -> n % i == 0).count();
    }

    int[][] nbOfDiv() {
        int[][] mat = new int[N + 1][N + 1];
        range(1, N).forEach(i -> range(1, N).forEach(j -> mat[i][j] = nbOfDiv(i * j)));
        return mat;
    }

    public record Paire(Integer i, Integer j) {
    }
}

