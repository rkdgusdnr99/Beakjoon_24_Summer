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

        System.out.println(maxProcession(p, N));
    }

    static int maxProcession(int[] p, int n) {
        int[][] dp = new int[n][n];

        for(int i=2; i<n+1; i++) { // 구간 간격
            for(int j=0; j<n-i+1; j++) { // 구간 시작점 j (0~n-i))
                dp[j][j+i-1] = Integer.MAX_VALUE;
                for(int k=j; k<j+i-1; k++) { // 중간 지점 k (j~ j+i-1))
                    int value = dp[j][k]  + dp[k+1][j+i-1] + (p[j]*p[k+1]*p[j+i]);
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
                }
            }
        }
        return dp[0][n-1];
    }

}
