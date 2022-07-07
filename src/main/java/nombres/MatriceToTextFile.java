package nombres;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.util.stream.IntStream.range;

public class MatriceToTextFile {

    public static void matriceToTextFile(int[][] tab, String fileaddr, String filename, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        range(1, n + 1).forEach(i -> {
            range(1, n + 1).forEach(j -> sb.append(tab[i][j]).append(","));
            sb.append("\n");
        });

        FileWriter fw = new FileWriter(fileaddr + filename + n + ".txt", false);
        BufferedWriter output = new BufferedWriter(fw);
        output.write(sb.toString());
        output.flush();
        output.close();

    }

}
