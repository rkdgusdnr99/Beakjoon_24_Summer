package part4;

import java.io.*;
import java.util.*;

public class 아기상어2_17086번 {
    static int N,M;
    static int[] xMove = {0,0,-1,1,-1,1,-1,1};
    static int[] yMove = {1,-1,0,0,1,-1,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int[][] sd;
    static Queue<int[]> shark;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        sd = new int[N][M];
        shark = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(line[j]);
                map[i][j] = num;
                if (num == 1) {
                    shark.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(sd[i], 10000);
        }

        while (!shark.isEmpty()) {
            int[] pos = shark.poll();
            int y = pos[0];
            int x = pos[1];
            findShark(y, x);
            visited = new boolean[N][M];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(sd[i][j], max);
            }
        }

        System.out.println(max);
    }

    static void findShark(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x,0});
        visited[y][x] = true;
        sd[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int nowY = pos[0];
            int nowX = pos[1];
            int distance = pos[2];

            for (int i = 0; i < 8; i++) {
                int nextY = nowY + yMove[i];
                int nextX = nowX + xMove[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N
                        && !visited[nextY][nextX] && sd[nextY][nextX] > distance + 1) {
                    queue.add(new int[]{nextY, nextX, distance + 1});
                    visited[nextY][nextX] = true;
                    sd[nextY][nextX] = distance + 1;
                }
            }
        }
    }
}
