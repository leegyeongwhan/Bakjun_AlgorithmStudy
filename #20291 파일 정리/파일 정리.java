import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] split = line.split("\\.");
            if (!map.containsKey(split[1])) {
                map.put(split[1], 1);
            } else {
                Integer value = map.get(split[1]) + 1;
                map.put(split[1], value);
            }
        }
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // key를 기준으로 비교하는 로직 작성
                return o1.getKey().compareTo(o2.getKey());
            }
        };

        List<Map.Entry<String, Integer>> collect = map.entrySet()
                .stream().sorted(comparator)
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : collect) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
//2 1 3 2
// 0   1322
//  3221
//