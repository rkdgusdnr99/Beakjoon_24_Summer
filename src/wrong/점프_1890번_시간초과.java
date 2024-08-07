package wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프_1890번_시간초과 {
    static int N;
    static int[][] jump;
    static int max;

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

        routeCount(0, 0);

        System.out.println(max);
    }

    static void routeCount(int y, int x) {
        if (jump[y][x] == 0) {
            max += 1;
            return;
        }
        if (jump[y][x] + y < N) {
            routeCount(y + jump[y][x], x);
        }
        if (jump[y][x] + x < N) {
            routeCount(y, x + jump[y][x]);
        }
    }

}
