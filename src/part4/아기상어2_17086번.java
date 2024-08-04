package part4;

import java.io.*;
import java.util.*;

public class 아기상어2_17086번 {
    static int N,M;
    static int[] xMove = {0,0,-1,1,-1,1,-1,1};
    static int[] yMove = {1,-1,0,0,1,-1,-1,1};
    static int[][] sd;
    static Queue<int[]> shark;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        sd = new int[N][M];
        shark = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(line[j]) == 1) {
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
                        && sd[nextY][nextX] > distance + 1) {
                    queue.add(new int[]{nextY, nextX, distance + 1});
                    sd[nextY][nextX] = distance + 1;
                }
            }
        }
    }
}
