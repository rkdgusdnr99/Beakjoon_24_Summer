package wrong;

import java.util.*;

public class 줄세우기_2252번_오답 {
    static int N, M;
    static ArrayList<Stack<Integer>> leftList;
    static ArrayList<Stack<Integer>> rightList;
    static boolean[] lined;
    static StringBuilder line;
    static int position = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            leftList.add(new Stack<>());
            rightList.add(new Stack<>());
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            leftList.get(B).add(A);
            rightList.get(A).add(B);
        }
        lined = new boolean[N+1];
        line = new StringBuilder();

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!lined[i]) {
                count++;
                line.insert(position, i);
                lined[i] = true;
                while (!leftList.get(i).isEmpty()) {
                    int temp = leftList.get(i).pop();
                    if (!lined[temp]) {
                        lineUp(0, temp);
                    }
                }
                while (!rightList.get(i).isEmpty()) {
                    position += count;
                    count = 0;
                    int temp = rightList.get(i).pop();
                    if (!lined[temp]) {
                        lineUp(0, temp);
                    }
                }
            }
        }
        System.out.println(line);

    }

    static void lineUp(int count, int student) {
        count++;
        line.insert(position, student);
        lined[student] = true;

        while (!leftList.get(student).isEmpty()) {
            int temp = leftList.get(student).pop();
            if (!lined[temp]) {
                lineUp(count, temp);
            }
        }
        while (!rightList.get(student).isEmpty()) {
            position += count;
            count = 0;
            int temp = rightList.get(student).pop();
            if (!lined[temp]) {
                lineUp(count, temp);
            }
        }
    }
}
