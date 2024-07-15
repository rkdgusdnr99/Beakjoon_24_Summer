package part3;

import java.util.*;

public class 동전2_2294번 {
    static int n, k;
    static int min;
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        min = k+1;
        coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        dp = new int[k+1];
        Arrays.fill(dp, k+1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]]+1);
            }
        }

        if (dp[k] > k) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }

}
