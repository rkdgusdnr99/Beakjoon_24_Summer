package wrong;

import java.util.Scanner;

public class 괄호_10422_틀림 {
    static int T;
    static int[] L;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        L = new int[T];

        for (int i = 0; i < T; i++) {
            L[i] = sc.nextInt();
        }

        dp = new long[5001];

        parentheses();

        for (int i = 0; i < T; i++) {
            System.out.println(dp[L[i]]);
        }
    }

    static void parentheses() {
        dp[2] = 1;
        long sum = 1;
        for (int i = 4; i <= 5000; i+=2) {
            dp[i] = dp[i-2] + sum; // 2 5 13 34
            sum += dp[i]; // 3 8 21 55
        }
    }
}
