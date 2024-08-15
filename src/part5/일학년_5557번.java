package part5;

import java.util.Scanner;

public class 일학년_5557번 {
    static int N;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new long[N-1][21];

        int first = sc.nextInt();
        dp[0][first] = 1;

        for (int i = 1; i < N-1; i++) {
            int num = sc.nextInt();

            for (int j = 0; j <= 20; j++) {
                if (dp[i-1][j] > 0) {
                    if (j + num <= 20) {
                        dp[i][j + num] += dp[i-1][j];
                    }
                    if (j - num >= 0) {
                        dp[i][j - num] += dp[i-1][j];
                    }
                }
            }
        }

        int last = sc.nextInt();

        System.out.println(dp[N-2][last]);

    }
}
