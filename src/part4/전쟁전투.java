package part4;

import java.io.*;

public class 전쟁전투 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static int sum = 0;
    static int bSum = 0;
    static int wSum = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = br.readLine().split(" ");
        N = Integer.parseInt(dimensions[0]);
        M = Integer.parseInt(dimensions[1]);

        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[M][N];
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    if (map[y][x] == 'B') {
                        solider(y, x, 'B');
                        bSum += sum * sum;
                        sum = 0;
                    } else {
                        solider(y, x, 'W');
                        wSum += sum * sum;
                        sum = 0;
                    }
                }
            }
        }

        System.out.println(wSum + " " + bSum);


    }

    static void solider(int y, int x, char word) {
        visited[y][x] = true;
        sum++;
        for (int i = 0; i < 4; i++) {
            if (y+yMove[i] >= 0 && y+yMove[i] < M && x+xMove[i] >= 0 &&x+xMove[i] < N) {
                if(!visited[y+yMove[i]][x+xMove[i]] && map[y+yMove[i]][x+xMove[i]] == word) {
                    solider(y+yMove[i], x+xMove[i], word);
                }
            }
        }
    }

}
