package part4;

import java.util.*;

public class 바이러스_2606번 {
    static int N, K;
    static List<Queue<Integer>> network;
    static boolean[] visited;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        network = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            network.add(new LinkedList<>());
        }
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            network.get(x).add(y);
            network.get(y).add(x);
        }

        visited = new boolean[N+1];

        bfs();

        System.out.println(sum);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            while (!network.get(now).isEmpty()) {
                int next = network.get(now).poll();
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    sum++;
                }
            }
        }
    }
}
