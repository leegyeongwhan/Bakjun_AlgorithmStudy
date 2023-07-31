
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Student[] students = new Student[101];
        List<Student> list = new ArrayList<>();

        //1. 처음 추천 받는겨웅

        //1. 이미 엑자에 게시된경우
        //2. 처음 엑자에 게시되는경우
        for (int i = 0; i < s; i++) {
            int order = Integer.parseInt(st.nextToken());
            if (students[order] == null) {
                students[order] = new Student(order, 0, 0, false);
            }

            if (students[order].isPosted) {
                students[order].cnt++;
            } else {
                if (list.size() == n) {
                    list.sort((o1, o2) -> {
                        if (o1.cnt == o2.cnt) {
                            return o1.time - o2.time;
                        }
                        return o1.cnt - o2.cnt;
                    });
                    list.get(0).isPosted = false;
                    list.remove(0);
                }
                students[order].cnt = 1;
                students[order].time = i;
                students[order].isPosted = true;
                list.add(students[order]);
            }
        }

        list.sort((o1, o2) -> o1.num - o2.num);
        for (Student student : list) {
            System.out.print(student.num + " ");
        }
    }

    StringBuilder sb = new StringBuilder();

    static class Student {
        int num;
        int cnt;
        int time;
        boolean isPosted;

        public Student(int idx, int cnt, int time, boolean isPosted) {
            this.num = idx;
            this.cnt = cnt;
            this.time = time;
            this.isPosted = isPosted;
        }
    }// class Student
}
