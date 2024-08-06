package part5;

import java.io.*;
import java.util.*;

public class 퇴사2_15486번 {
    static int N;
    static List<Queue<int[]>> schedule;
    static int[] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        max = new int[N+1];
        schedule = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            schedule.add(new LinkedList<>());
        }

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int term = Integer.parseInt(st.nextToken());  // 기간
            int reward = Integer.parseInt(st.nextToken());  // 보상
            if (i + term <= N+1) { // 출발지점과 보상을 저장
                schedule.get(i + term - 1).add(new int[]{i, reward});
            }
        }

        findMax();

        System.out.println(max[N]);

    }
    static void findMax() {
        for (int i = 1; i <= N; i++) {
            max[i] = max[i-1];
            while (!schedule.get(i).isEmpty()) {
                int[] arr = schedule.get(i).poll();
                max[i] = Math.max(max[i], arr[1] + max[arr[0]-1]);
            }
        }
    }
}
