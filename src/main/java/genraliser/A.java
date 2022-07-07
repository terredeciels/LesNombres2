package genraliser;

import java.io.IOException;

import static nombres.MatriceToTextFile.matriceToTextFile;

public class A extends AA {

    public static void main(String[] args) throws IOException {
        new A().F();
    }

    void F() throws IOException {
        I.get()
                .forEach(i -> I.get()
                        .forEach(j -> I.get()
                                .forEach(k -> I.get()
                                        .forEach(l -> {
                                            if (f.apply(i, j).equals(f.apply(k, l))) tF[i][j]++;
                                        }))));
        matriceToTextFile(tF, chemin, "f_", N);
    }
}
