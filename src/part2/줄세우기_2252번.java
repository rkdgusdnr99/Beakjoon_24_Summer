package part2;

import java.util.*;

public class 줄세우기_2252번 {
    static int N, M;
    static Queue<Integer> queue;
    static List<Integer>[] rightList;
    static int[] left;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        rightList = new ArrayList[N + 1];
        left = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            rightList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            rightList[A].add(B);
            left[B]++;
        }

        queue = new LinkedList<>();
        sb = new StringBuilder();
        bfs();
        System.out.println(sb.toString());

    }

    static void bfs() {
        for (int i = 1; i <= N; i++) {
            if (left[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp + " ");
            for (int num : rightList[temp]) {
                left[num]--;
                if (left[num] == 0) {
                    queue.add(num);
                }
            }
        }
    }
}
