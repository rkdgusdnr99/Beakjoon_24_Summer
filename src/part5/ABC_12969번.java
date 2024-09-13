package part5;

import java.util.*;
public class ABC_12969번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(dpBfs(N, K));
    }

    static String dpBfs(int N, int K) {
        String[][][][] dp = new String[N+1][N+1][N+1][K+1]; // dp[a][b][c][쌍]

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];
            int sum = cur[3];
            String now = dp[a][b][c][sum];
            if (now == null) { // null 지워야함 안그러면 nullABC 처럼 이상하게 나옴
                now = "";
            }

            if (sum == K) { // 목표값까지 도달 시
                int temp = N - a - b - c;
                if (temp > 0) { // 문자를 다 쓰지 않아도 앞에 C로 채워넣으면 됨
                    now = "C".repeat(temp) + now;
                }
                return now;
            }

            if (a + b + c >= N) { // 문자를 다 썼다면 건너 뛰기
                continue;
            }

            // 사용된 abc 수와 그에 따른 순서쌍의 수가 같다면, abc의 순서에 상관 없이 중복임
            if (dp[a+1][b][c][sum] == null) {
                dp[a+1][b][c][sum] = now + "A";
                queue.add(new int[]{a+1,b,c,sum});
            }
            if (sum + a <= K && dp[a][b+1][c][sum+a] == null) {
                dp[a][b+1][c][sum+a] = now + "B";
                queue.add(new int[]{a,b+1,c,sum+a});
            }
            if (sum + a + b <= K && dp[a][b][c+1][sum + a + b] == null) {
                dp[a][b][c+1][sum+a+b] = now + "C";
                queue.add(new int[]{a,b,c+1,sum+a+b});
            }
        }
        return "-1";
    }
}
