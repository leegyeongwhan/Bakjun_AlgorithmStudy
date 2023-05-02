import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }
            
            //받은 문자열의 알파벳 초기화
            int[] arr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }

            //문자를 돌면서 문자열길이의 최솟값 최댓값을 구분 지어한다.
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < str.length(); j++) {
                //길이가 k와같을때만 계산한다
                if (arr[str.charAt(j) - 'a'] < k) {
                    continue;
                }
                int cnt = 1;
                for (int l = j + 1; l < str.length(); l++) {
                    if (str.charAt(l) == str.charAt(j)) {
                        cnt++;
                    }
                    if (cnt == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}