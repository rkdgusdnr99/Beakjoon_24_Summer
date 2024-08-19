package part5;

import java.util.*;

public class 소형기관차_2616번 {
    static int N;
    static int[] cars;
    static int M;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cars = new int[N+1];
        sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            cars[i] = sc.nextInt();
            sum[i] = sum[i-1] + cars[i];
        }
        M = sc.nextInt();

        dp = new int[4][N+1];

        for (int i = 1; i < 4; i++) {
            for (int j = i * M; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-M] + sum[j] - sum[j-M]);
            }
        }
        System.out.println(dp[3][N]);
        // 이해 편함
//        for (int i = M; i <= N; i++) {
//            if (i >= M) {
//                dp[1][i] = Math.max(dp[1][i-1], dp[0][i-M] + sum[i] - sum[i-M]);
//            }
//            if (i >= M*2) {
//                dp[2][i] = Math.max(dp[2][i-1], dp[1][i-M] + sum[i] - sum[i-M]);
//            }
//            if (i >= M*3) {
//                dp[3][i] = Math.max(dp[3][i-1], dp[2][i-M] + sum[i] - sum[i-M]);
//            }
//        }
    }

}
