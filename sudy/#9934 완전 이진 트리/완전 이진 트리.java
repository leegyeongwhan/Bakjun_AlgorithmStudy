
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    private static List<List<Integer>> list = new ArrayList<>();
    private static StringBuffer sb = new StringBuffer();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[(int) Math.pow(2, K) - 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (Integer.valueOf(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }
        search(0, arr.length - 1, 0);
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
//arr 3  6 , 2  , 1,4 , 5,7
    }

    // 0 , 6 ,0
    // mid = 3
    // add(3)
    // search(0, 2), search (4,6)
    //
//  1 6 4 3 5 2 7
    private static void search(int start, int end, int depth) {
        if (K == depth) {
            return;
        }
        int mid = (start + end) / 2;
        list.get(depth).add(arr[mid]);
        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }
}

