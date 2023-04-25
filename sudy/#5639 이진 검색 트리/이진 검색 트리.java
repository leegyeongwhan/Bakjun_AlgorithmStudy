import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        search(root);
        return;
    }

    private static void search(Node node) {
        if (node == null){
            return;
        }
        search(node.left);
        search(node.right);
        System.out.println(node.value);
    }
}

/**
 * 위의 num 의정보로 이진탐색 트리를 구현한 후 검색(후위 순위)
 */
class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }


    void insert(int num) {
        //작으면 왼족 크면 오른쪽
        if (this.value > num) {
            if (this.left == null) {
                left = new Node(num);
            } else {
                left.insert(num);
            }
        } else {
            if (this.right == null) {
                right = new Node(num);
            } else {
                right.insert(num);
            }
        }
    }
}