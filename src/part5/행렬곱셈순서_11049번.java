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
        int[][] dp = new int[n+1][n+1];

        for(int count = 2; count <= n; count++) { // 사용되는 행렬 개수
            for(int end = count; end <= n; end++) { // 마지막 행렬의 순번
                dp[count][end] = Integer.MAX_VALUE;

                for(int k = 1; k < count; k++) { // k : count - k 로 행렬을 나눔
                    int start = end - count + 1;
                    int candidate = dp[k][end-count+k] + dp[count - k][end] + p[start - 1] * p[end - count + k] * p[end];
                    dp[count][end] = Math.min(dp[count][end], candidate);
                }
            }
        }
        return dp[n][n];
    }
}