package wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2_15486번_시간초과 {
    static int N;
    static int[][] schedule;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        schedule = new int[N+1][2];
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());  // 기간
            schedule[i][1] = Integer.parseInt(st.nextToken());  // 보상
        }

        findMax(1, 0);

        System.out.println(max);
    }
    static void findMax(int start, int sum) {
        for (int i = start; i < N+1; i++) {
            if (schedule[i][0] == 1) {
                sum += schedule[i][1];
            } else if (schedule[i][0] + i <= N+1) {
                findMax(schedule[i][0] + i, sum + schedule[i][1]);
            }
        }
        max = Math.max(max, sum);
    }
}
