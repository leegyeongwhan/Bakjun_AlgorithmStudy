import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[n - 1];
        int dasom = 0;
        dasom = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        int cnt = 0;

        if (arr.length == 0) {
            System.out.println(0);
            return;
        }

//        if (arr.length == 1) {
//            System.out.println(arr[0] - dasom);
//            return;
//        }

//        for (int i = 0; i < arr.length; i++) {
//            if (max < arr[i]) {
//                max = arr[i];
//            }
//        }

        while (true) {
            Arrays.sort(arr);
            if (arr[arr.length - 1] < dasom) {
                System.out.println(cnt);
                return;
            }
            cnt++;
            dasom++;
            arr[arr.length - 1]--;

        }
    }
}