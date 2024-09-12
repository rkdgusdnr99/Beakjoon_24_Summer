package part5;

import java.io.*;
import java.util.StringTokenizer;

public class 팰린드롬_10942번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];
        palindrome(N, arr, dp);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void palindrome(int N, int[] arr, int[][] dp) {
        for (int i = 1; i <= N; i++) { // 길이가 1일때
            dp[i][i] = 1;
        }

        for (int i = 1; i < N; i++) { // 길이가 2일때
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < N; i++) { // 길이가 3 이상일 때
            for (int j = 1; j + i<= N; j++) {
                if (dp[j+1][j+i-1] == 1) { // (2, 5)가 팰린드롬이려면, (3, 4)는 무조건 팰린드롬 이여야 함
                    if (arr[j] == arr[j+i]) { // (3, 4)가 팰린드롬이라면, (2) 와 (5)만 비교하면 됨
                        dp[j][j+i] = 1;
                    }
                }
            }
        }
    }
}
