package part5;

import java.util.*;

public class 평범한배낭_12865번 {
    static int N, K;
    static int[] wList;
    static int[] vList;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // ~100
        K = sc.nextInt();

        wList = new int[N+1];
        vList = new int[N+1];
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            wList[i] = sc.nextInt();
            vList[i] = sc.nextInt();
        }

        findMax();

        System.out.println(dp[N][K]);
    }

    static void findMax() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= wList[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wList[i]]+vList[i]);
                }
            }
        }
    }
}
