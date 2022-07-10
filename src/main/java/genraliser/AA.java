package genraliser;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class AA {
    int N = 32;
    Supplier<IntStream> I = () -> range(1, N);
    String chemin = "C:\\Users\\gille\\IdeaProjects\\LesNombres" +
            "\\src\\main\\java\\nombres\\";

    int[][] tf = new int[N + 1][N + 1];
    int[][] tF = new int[N + 1][N + 1];
    BiFunction<Integer, Integer, Integer> f = (i, j) -> i * j;
    //BiFunction<Integer, Integer, Integer> f = (i, j) -> i + j + i * j;

    // BiFunction<Integer, Integer, Integer> f = Integer::sum;
    {
        I.get().forEach(i -> I.get().forEach(j -> tf[i][j] = f.apply(i, j)));
    }

}
