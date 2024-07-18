package part3;

import java.io.*;

public class 파이프옮기기1_17070번 {

    static int N;
    static int[][] house;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        house = new int[N][N];

        for (int y = N-1; y >= 0; y--) {// 파이프는 시작시(0, N-1), (1, N-1)에 존재
            String line = br.readLine();
            String[] numbers = line.split("\\s+"); // 하나 이상의 공백을 기준으로 분리
            for (int x = 0; x < N; x++) {
                house[y][x] = Integer.parseInt(numbers[x]);
            }
        }

        recursion(N-1, 1, 0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static void recursion(int y, int x, int type) {
        if (y == 0 && x == N-1) {
            count++;
            return;
        }
        if (type == 0 || type == 2) { // 가로 또는 대각
            if (x + 1 < N && house[y][x + 1] == 0) {
                recursion(y, x + 1, 0);
            }
        }
        if (type == 1 || type == 2) { // 세로 또는 대각
            if (y - 1 >= 0 && house[y - 1][x] == 0) {
                recursion(y - 1, x, 1);
            }
        }
        if (x + 1 < N && y - 1 >= 0 && house[y - 1][x] == 0 && house[y][x + 1] == 0 && house[y - 1][x + 1] == 0) {
            recursion(y - 1, x + 1, 2);
        }
    }

    static void recursion2(int y, int x, int type) {
        if (y == 0 && x == N - 1) {
            count++;
            return;
        }

        // 가로 이동
        if (type == 0) {
            if (x + 1 < N && house[y][x + 1] == 0) {
                recursion(y, x + 1, 0);
            }
        }

        // 세로 이동
        if (type == 1) {
            if (y - 1 >= 0 && house[y - 1][x] == 0) {
                recursion(y - 1, x, 1);
            }
        }

        // 대각선 이동
        if (type == 2) {
            if (x + 1 < N && house[y][x + 1] == 0) {
                recursion(y, x + 1, 0);
            }
            if (y - 1 >= 0 && house[y - 1][x] == 0) {
                recursion(y - 1, x, 1);
            }
        }

        // 대각선 이동 (모든 타입에서 가능)
        if (x + 1 < N && y - 1 >= 0 && house[y - 1][x] == 0 && house[y][x + 1] == 0 && house[y - 1][x + 1] == 0) {
            recursion(y - 1, x + 1, 2);
        }
    }
}
