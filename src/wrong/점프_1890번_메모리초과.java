package wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프_1890번_메모리초과 {
    static int N;
    static int[][] jump;
    static int[][] sum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        jump = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                jump[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum = new int[N][N];
        sum[0][0] = 1;

        routeCount();

        System.out.println(sum[N - 1][N - 1]);
    }

    static void routeCount() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            if (nowX == N - 1 && nowY == N - 1) {
                continue;
            }
            if (nowY + jump[nowY][nowX] < N) {
                queue.add(new int[]{nowY + jump[nowY][nowX], nowX});
                sum[nowY+ jump[nowY][nowX]][nowX] += sum[nowY][nowX];
            }
            if (nowX + jump[nowY][nowX] < N) {
                queue.add(new int[]{nowY, nowX + jump[nowY][nowX]});
                sum[nowY][nowX + jump[nowY][nowX]] += sum[nowY][nowX];
            }
        }
    }

}
