package part5;

import java.io.*;
import java.util.*;

public class 점프_1890번 {
    static int N;
    static int[][] jump;
    static long[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        jump = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                jump[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[N][N];
        dp[0][0] = 1;
        visited = new boolean[N][N];
        visited[0][0] = true;

        routeCount();

        System.out.println(dp[N - 1][N - 1]);
    }

    static void routeCount() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    continue;
                }
                if (jump[y][x] == 0) {
                    break;
                }
                if (y + jump[y][x] < N) {
                    dp[y + jump[y][x]][x] += dp[y][x];
                    visited[y + jump[y][x]][x] = true;
                }
                if (x + jump[y][x] < N) {
                    dp[y][x + jump[y][x]] += dp[y][x];
                    visited[y][x + jump[y][x]] = true;
                }
            }
        }
    }

}
