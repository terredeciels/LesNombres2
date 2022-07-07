package traitement;

import static java.util.stream.IntStream.range;

public class M {

    private final int N;
    private final int[][] t;

    public M(int n) {
        N = n;
        t = new int[N][N];
    }

    public M(int n, int[][] tab) {
        N = n;
        t = tab;

    }

    public int[][] extract(int i, int j, int k, int l) {
        int[][] mat = new int[k - i][l - j];
        range(i, k).forEach(p -> range(j, l).forEach(q -> mat[p][q] = t[p][q]));
        return mat;
    }

    public M extract(int i, int j, int d) {
        int[][] mat = new int[i + d][j + d];
        range(i, i + d).forEach(p -> range(j, j + d).forEach(q -> mat[p][q] = t[p][q]));
        return new M(d, mat);
    }

    public int getN() {
        return N;
    }

    public int[][] getTqb() {
        return t;
    }
}
