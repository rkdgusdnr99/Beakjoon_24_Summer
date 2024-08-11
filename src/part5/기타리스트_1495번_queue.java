package part5;

import java.util.*;

public class 기타리스트_1495번_queue {
    static int N, S, M;
    static Queue<Integer> queue;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt(); // 초기값
        M = sc.nextInt(); // 최댓값

        queue = new LinkedList<>();
        visited = new boolean[N+1][M+1];

        queue.add(S);
        visited[0][S] = true;


        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int size = queue.size();

            if (size == 0) {
                System.out.println(-1);
                System.exit(0);
            }

            for (int j = 0; j < size; j++) {
                int temp = queue.poll();
                if (temp + num <= M && !visited[i+1][temp+num]) {
                    visited[i+1][temp+num] = true;
                    queue.add(temp + num);
                }
                if (temp - num >= 0 && !visited[i+1][temp-num]) {
                    visited[i+1][temp-num] = true;
                    queue.add(temp - num);
                }
            }
        }

        int max = -1;
        for (int i = M; i >= 0; i--) {
            if (visited[N][i]) {
                max = i;
                break;
            }
        }
        System.out.println(max);

    }
}
