package part5;

import java.util.Scanner;

public class 괄호_10422 {
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
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j < i; j++) {
                dp[i*2] += dp[j*2] * dp[(i-j-1)*2];
                dp[i*2] %= 1000000007;
            }
        }
    }
}
