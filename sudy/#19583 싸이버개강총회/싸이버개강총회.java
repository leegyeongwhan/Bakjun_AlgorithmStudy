
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken().replaceAll(":", ""));
        int milde = Integer.parseInt(st.nextToken().replaceAll(":", ""));
        int end = Integer.parseInt(st.nextToken().replaceAll(":", ""));

//        System.out.println("start = " + start);
//        System.out.println("milde = " + milde);
//        System.out.println("end = " + end);

        HashSet<String> user = new LinkedHashSet<>();
        int cnt = 0;
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line == null || line.isEmpty()) {
                break;
            }
            st = new StringTokenizer(line);

            String[] split = st.nextToken().split(":");
            int time = Integer.valueOf(split[0]) * 100 + Integer.valueOf(split[1]);
            String name = st.nextToken();

            if (start >= time) {
                user.add(name);
                continue;
            }
      //      System.out.println("time = " + time);
            if (milde <= time && end >= time && user.contains(name)) {
                cnt++;
  //              System.out.println("cnt = " + cnt);
                user.remove(name);
            }
        }

        //    System.out.println("user = " + user);
        //    System.out.println("attendance = " + attendance);
        System.out.println(cnt);
    }
}
