package part4;

import java.io.*;
import java.util.*;

class Miro implements Comparable<Miro> {
    int y;
    int x;
    int sum;
    public Miro(int y, int x, int sum) {
        this.y = y;
        this.x = x;
        this.sum = sum;
    }
    @Override
    public int compareTo(Miro other) {
        return Integer.compare(this.sum, other.sum);
    }
}

public class 미로탐색_2178번 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static PriorityQueue<Miro> routes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = br.readLine().split(" ");
        N = Integer.parseInt(dimensions[0]);
        M = Integer.parseInt(dimensions[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        routes = new PriorityQueue<>();
        visited = new boolean[N][M];
        routes.add(new Miro(0,0,1));

        while (!routes.isEmpty()) {
            Miro miro = routes.poll();
            int y = miro.y;
            int x = miro.x;
            int sum = miro.sum;
            for (int i = 0; i < 4; i++) {
                int nextY = y+yMove[i];
                int nextX = x+xMove[i];
                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    if(!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                        routes.add(new Miro(nextY, nextX, sum+1));
                        visited[nextY][nextX] = true;
                        if (y+yMove[i] == N-1 && x+xMove[i] == M-1) {
                            return sum+1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
