package part3;

import java.util.*;

public class 동전1_2293번 {
    static int n, k;
    static int count = 0;
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        coins = new int[n];
        dp = new int[k+1];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);
        
    }
}
