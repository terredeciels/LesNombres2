package nombres1D;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class Partition {

    List<Integer> Prod = new ArrayList<>();
    Map<Boolean, Long> mapCount;

    {
        int N = 32;
        range(1, N).forEach(i -> range(1, N).forEach(j -> Prod.add(i * j)));

        for (int niv = 0; niv < N * N; niv++) {
            StringBuilder sb = new StringBuilder();
            int finalNiv = niv;
            mapCount = Prod.stream().collect(Collectors
                    .partitioningBy(p -> (p == finalNiv), Collectors.counting()));
            // mapCount.forEach((Boolean key, Long count) -> System.out.println(key + " count -> " + count));

            for (Map.Entry<Boolean, Long> mapentry : mapCount.entrySet())
                if (mapentry.getKey()) sb.append(niv).append(",").append(mapentry.getValue()).append("\n");

            System.out.println(sb);

        }
    }

    public static void main(String[] args) {
        new Partition();
    }
}
