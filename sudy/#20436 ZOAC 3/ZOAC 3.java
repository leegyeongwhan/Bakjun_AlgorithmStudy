import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, KeyPoint> leftKeyboard = new HashMap<String, KeyPoint>();
    static Map<String, KeyPoint> rightKeyboard = new HashMap<String, KeyPoint>();

    static {
        leftKeyboard.put("q", new KeyPoint(0, 0));
        leftKeyboard.put("w", new KeyPoint(1, 0));
        leftKeyboard.put("e", new KeyPoint(2, 0));
        leftKeyboard.put("r", new KeyPoint(3, 0));
        leftKeyboard.put("t", new KeyPoint(4, 0));
        rightKeyboard.put("y", new KeyPoint(5, 0));
        rightKeyboard.put("u", new KeyPoint(6, 0));
        rightKeyboard.put("i", new KeyPoint(7, 0));
        rightKeyboard.put("o", new KeyPoint(8, 0));
        rightKeyboard.put("p", new KeyPoint(9, 0));

        leftKeyboard.put("a", new KeyPoint(0, 1));
        leftKeyboard.put("s", new KeyPoint(1, 1));
        leftKeyboard.put("d", new KeyPoint(2, 1));
        leftKeyboard.put("f", new KeyPoint(3, 1));
        leftKeyboard.put("g", new KeyPoint(4, 1));
        rightKeyboard.put("h", new KeyPoint(5, 1));
        rightKeyboard.put("j", new KeyPoint(6, 1));
        rightKeyboard.put("k", new KeyPoint(7, 1));
        rightKeyboard.put("l", new KeyPoint(8, 1));

        leftKeyboard.put("z", new KeyPoint(0, 2));
        leftKeyboard.put("x", new KeyPoint(1, 2));
        leftKeyboard.put("c", new KeyPoint(2, 2));
        leftKeyboard.put("v", new KeyPoint(3, 2));
        rightKeyboard.put("b", new KeyPoint(4, 2));
        rightKeyboard.put("n", new KeyPoint(5, 2));
        rightKeyboard.put("m", new KeyPoint(6, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());


        String left = stringTokenizer.nextToken();
        String right = stringTokenizer.nextToken();
        String str = br.readLine();

        System.out.println(makeKeyBoard(left, right, str));
    }


    private static int makeKeyBoard(String left, String right, String str) {
        int time = 0;
        for (char find : str.toCharArray()) { // zoac
            KeyPoint front;
            KeyPoint last;
            if (leftKeyboard.containsKey(find + "")) {
                front = leftKeyboard.get(left);
                last = leftKeyboard.get(find + "");
                left = find + "";
            } else {
                front = rightKeyboard.get(right);
                last = rightKeyboard.get(find + "");
                right = find + "";
            }

            time += (Math.abs(front.getX() - last.getX()) + Math.abs(front.getY() - last.getY()));
            time += 1;
        }
        return time;
    }
}

class KeyPoint {
    int x;
    int y;

    public KeyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}