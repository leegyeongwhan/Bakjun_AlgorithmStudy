
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(height, width);
        for (int i = 0; i < turn; i++) {
            rotate(height, width, map, min);
        }

        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int height, int width, int[][] map, int min) {
        for (int i = 0; i < min / 2; i++) {
            int h = height - i - 1;
            int w = width - i - 1;

            int tmp = map[i][i];

            for (int j = i; j < w; j++) {
                map[i][j] = map[i][j + 1];
            }

            for (int j = i; j < h; j++) {
                map[j][w] = map[j + 1][w];
            }

            for (int j = w; j > i; j--) {
                map[h][j] = map[h][j - 1];
            }

            for (int j = h; j > i; j--) {
                map[j][i] = map[j - 1][i];
            }

            map[i + 1][i] = tmp;
        }
    }
}
