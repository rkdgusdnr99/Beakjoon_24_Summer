package wrong;

import java.util.Scanner;

public class 팰린드롬_10942번_시간초과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int dp[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }
        palindrome(N, arr, dp);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(dp[start][end]);
        }

    }

    static void palindrome(int N, int[] arr, int[][] dp) {
        for (int i = 2; i < N; i+=2) {
            for (int j = 1; j + i<= N; j++) {
                if (dp[j+1][j+i-1] == 1) {
                    if (arr[j] == arr[j+i]) {
                        dp[j][j+i] = 1;
                    }
                }
            }
        }
    }
}
