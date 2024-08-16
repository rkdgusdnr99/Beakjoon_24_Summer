package part5;

import java.util.*;

public class 데스노트_2281번 {
    static int n, m;
    static int[] names;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        names = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.nextInt();
        }

        dp = new int[n][m+1]; // 순번, 지금 층 합
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][names[0]] = 0;

        findMin();

        for (int i = 0; i < m; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        System.out.println(min);
    }

    static void findMin() {
        for (int i = 1; i < n; i++) {
            int now = names[i];
            for (int j = 0; j <= m; j++) {
                if (dp[i-1][j] != Integer.MAX_VALUE) {
                    if (j + now + 1 <= m) {
                        dp[i][j+now+1] = Math.min(dp[i-1][j], dp[i][j+now+1]);
                    }
                    dp[i][now] = Math.min(dp[i-1][j] + (m-j) * (m-j), dp[i][now]);
                }
            }
        }
    }
}
