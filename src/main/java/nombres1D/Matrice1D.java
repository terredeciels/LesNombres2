package nombres1D;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.IntStream.range;
import static nombres.FonctionToTextFile.fonctionToTextFile;


public class Matrice1D {

    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres" +
            "\\src\\main\\java\\nombres\\";

    List<Integer> Prod = new ArrayList<>();
    List<Integer> ProdS;
    int N=32;

    public Matrice1D() throws IOException {
        range(1, N).forEach(i -> range(1, N).forEach(j -> Prod.add(i * j)));
        ProdS = Prod.stream().distinct().sorted().toList();

        Map<Integer, Integer> F = new HashMap<>();
        ProdS.forEach(p -> F.put(p, d(p)));
        fonctionToTextFile(F, chemin, "Fonction2_", N);
    }

    int d(int n) {
        final int[] nbdiv = {0};
        range(1, N).forEach(i -> range(1, N).forEach(j -> {
            if (i * j == n) nbdiv[0]++;
        }));
        return nbdiv[0];
    }

    public static void main(String[] args) throws IOException {
        new Matrice1D();
    }
}
