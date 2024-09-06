package part5;

import java.util.*;

public class 파일합치기_11066번 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] output = new int[T];

        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            int[][][] dp = new int[K+1][K+1][2];
            for (int j = 2; j <= K; j++) {
                for (int k = 0; k <= K; k++) {
                    Arrays.fill(dp[j][k], Integer.MAX_VALUE);
                }
            }

            for (int j = 1; j <= K; j++) {
                dp[1][j][0] = sc.nextInt();
            }

            minCost(K, dp);
            output[i] = dp[K][K][1];
        }

        for (int i = 0; i < T; i++) { // 결과 출력
            System.out.println(output[i]);
        }
    }

    static void minCost(int K, int[][][] dp) {
        for (int fileNum = 2; fileNum <= K; fileNum++) { // 파일 묶음의 수
            for (int start = fileNum; start <= K; start++) { // 비교 시작점
                for (int i = 1; i < fileNum; i++) { // i : fileNum-i로 파일 묶음을 나눔
                    int tot = dp[i][start-fileNum+i][1] + dp[fileNum-i][start][1]; // 이전까지 계산한 값
                    int sum = dp[i][start-fileNum+i][0] + dp[fileNum-i][start][0]; // 새로 더해질 값
                    if (dp[fileNum][start][1] > tot + sum) {
                        dp[fileNum][start][1] = tot + sum;
                        dp[fileNum][start][0] = sum;
                    }
                }
            }
        }
    }
}
