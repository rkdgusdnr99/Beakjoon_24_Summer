package part4;

import java.io.*;
import java.util.*;

public class 달리기_16930번 {
    static int N, M, K;
    static boolean[][] gym;
    static int[][] visited;
    static int x1, y1, x2, y2;
    static int[] xMove = {1,-1,0,0};
    static int[] yMove = {0,0,1,-1};
    static int max = 999999999;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gym = new boolean[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], max);
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                gym[i][j] = line.charAt(j) == '.';
            }
        }

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(running());

    }

    static int running() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1, 0});
        visited[x1][y1] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int time = now[2];

            if (nowX == x2 && nowY == y2) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    int nextX = nowX + xMove[i] * j;
                    int nextY = nowY + yMove[i] * j;
                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M
                            || !gym[nextX][nextY] || visited[nextX][nextY] < time + 1) {
                        break;
                    }
                    if (visited[nextX][nextY] == max) {
                        queue.add(new int[]{nextX, nextY, time+1});
                        visited[nextX][nextY] = time+1;
                    }
                }
            }
        }

        return -1;
    }
}
