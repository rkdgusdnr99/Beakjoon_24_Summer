package part5;

import java.util.*;

public class 기타리스트_1495번_dp {
    static int N, S, M;
    static boolean[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt(); // 초기값
        M = sc.nextInt(); // 최댓값

        dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) {
                    if (j + num <= M) {
                        dp[i+1][j + num] = true;
                    }
                    if (j - num >= 0) {
                        dp[i+1][j - num] = true;
                    }
                }
            }
        }

        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
