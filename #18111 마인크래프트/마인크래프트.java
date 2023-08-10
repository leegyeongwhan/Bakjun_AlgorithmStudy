
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] < min) {
                    min = map[i][j];
                }

                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        Map<Integer, Integer> result = new HashMap<>();
        int maxTime = 100000000;
        int height = 0;
        for (int i = min; i <= max; i++) {
            int countBlock = B;
            int time = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < map[j][k]) {
                        time += (map[j][k] - i) * 2;
                        countBlock += (map[j][k] - i);
                    } else {
                        time += (i - map[j][k]) * 1;
                        countBlock -= (i - map[j][k]);
                    }
                }
            }
            if (countBlock < 0) break;
            if (maxTime >= time) {
                maxTime = time;
                height = i;
            }
        }

        System.out.println(maxTime + " " + height);
    }
}
