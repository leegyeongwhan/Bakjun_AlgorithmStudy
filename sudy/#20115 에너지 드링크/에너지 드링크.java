
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2 3 6 9 10
        //  2 + 1.5 = 3.5
        // 3 + 1 = 4

        // 4  6 9 10
        // 4 + 3 = 7
        // 6 + 2 = 8

        // 8 9 10
        // 8 + 3 = 11
        // 9 + 4 == 13

        // 13 10
        // 13 + 5 = 18
        // 10  + 6.5 = 16.5


        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        double sum = arr[n - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            sum += (double) arr[i] / 2;
        }

        System.out.println(sum);
    }
}
