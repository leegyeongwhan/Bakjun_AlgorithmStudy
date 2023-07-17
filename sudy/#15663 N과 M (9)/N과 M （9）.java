
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    static int[] after;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        arr = new int[N];
        after = new int[M];
        visit = new boolean[N];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = String.valueOf(st.nextToken());
            arr[i] = Integer.valueOf(s);
        }
        Arrays.sort(arr);
        dfs(0);
        set.forEach(System.out::println);
    }

    //
    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : after) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            after[depth] = arr[i];
            dfs(depth + 1);
            visit[i] = false;
        }
    }
}
