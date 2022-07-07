package nombres;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FonctionToTextFile {

    public static void fonctionToTextFile(Map<Integer, Integer> F, String fileaddr, String filename, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        F.forEach((key, value) -> sb.append(key).append(",").append(value).append("\n"));
System.out.println(sb);
        FileWriter fw = new FileWriter(fileaddr + filename + n + ".txt", false);
        BufferedWriter output = new BufferedWriter(fw);
        output.write(sb.toString());
        output.flush();
        output.close();

    }

}
