import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tall = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == 0 && cnt == tall) {
                    arr[j] = i + 1;
                    break;
                }

                if (arr[j] == 0 || arr[j] == i + 1) {
                    cnt++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
//2 1 3 2
// 0   1322
//  3221
//