package part4;

import java.io.*;
import java.util.*;

public class 음식물피하기_1743번 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static int max = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = br.readLine().split(" ");
        N = Integer.parseInt(dimensions[0]);
        M = Integer.parseInt(dimensions[1]);
        K = Integer.parseInt(dimensions[2]);

        queue = new LinkedList<>();
        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            String[] trash = br.readLine().split(" ");
            int y = Integer.parseInt(trash[0])-1;
            int x = Integer.parseInt(trash[1])-1;
            queue.add(new int[]{y, x});
            map[y][x] = 1;
        }

        visited = new boolean[N][M];
        while (!queue.isEmpty()) {
            int[] road = queue.poll();
            int y = road[0];
            int x = road[1];
            if (!visited[y][x]) {
                maxTrash(y, x);
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        System.out.println(max);
    }

    static void maxTrash(int y, int x) {
        sum++;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = y + yMove[i];
            int nextX = x + xMove[i];
            if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                if (!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    maxTrash(nextY, nextX);
                }
            }
        }
    }
}
