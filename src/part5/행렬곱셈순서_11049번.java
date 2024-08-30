package part5;

import java.util.*;

public class 행렬곱셈순서_11049번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] procession = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            procession[i][0] = sc.nextInt();
            procession[i][1] = sc.nextInt();
        }

        int[] p = new int[N+1];
        p[0] = procession[1][0];
        for (int i = 1; i <= N; i++) {
            p[i] = procession[i][1];
        }

        System.out.println(minProcession(p, N));
    }

    static int minProcession(int[] p, int n) {
        int[][] dp = new int[n][n];

        for(int length = 2; length <= n; length++) {
            for(int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++) {
                    int candidate = dp[i][k] + dp[k+1][j] + p[i] * p[k+1] * p[j+1];
                    dp[i][j] = Math.min(dp[i][j], candidate);
                }
            }
        }
        return dp[0][n-1];
    }
}

