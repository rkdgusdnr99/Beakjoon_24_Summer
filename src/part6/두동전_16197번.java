package part6;

import java.io.*;
import java.util.*;

public class 두동전_16197번 {

    static int[][] move = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[][] coins = new int[2][2];
        char[][] board = new char[N][M];
        int coinIndex = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'o') { // 동전 발견 시 위치 저장
                    coins[coinIndex][0] = i;
                    coins[coinIndex][1] = j;
                    coinIndex++;
                }
            }
        }

        System.out.println(dropCoin(coins, board, N, M));
    }

    static int dropCoin(int[][] coins, char[][] board, int N, int M) {
        boolean[][][][] visited = new boolean[N][M][N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{coins[0][0], coins[0][1], coins[1][0], coins[1][1], 0});
        visited[coins[0][0]][coins[0][1]][coins[1][0]][coins[1][1]] = true;
        visited[coins[0][0]][coins[0][1]][coins[0][0]][coins[0][1]] = true;
        visited[coins[1][0]][coins[1][1]][coins[1][0]][coins[1][1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int firstY = now[0];
            int firstX = now[1];
            int secondY = now[2];
            int secondX = now[3];
            int count = now[4];

            if (count == 10) {
                return -1;
            }

            for (int i = 0; i < 2; i++) {
                int nextFirstY = firstY + move[i][0];
                int nextSecondY = secondY + move[i][0];
                if (nextFirstY == N || nextFirstY < 0) {
                    if (nextSecondY < N && nextSecondY >= 0) {
                        return count + 1;
                    }
                    continue;
                } else if (nextSecondY == N || nextSecondY < 0) {
                    return count + 1;
                }
                if (board[nextFirstY][firstX] == '#') {
                    nextFirstY = firstY;
                }
                if (board[nextSecondY][secondX] == '#') {
                    nextSecondY = secondY;
                }
                if (!visited[nextFirstY][firstX][nextSecondY][secondX]) {
                    visited[nextFirstY][firstX][nextSecondY][secondX] = true;
                    visited[nextFirstY][firstX][nextFirstY][firstX] = true;
                    visited[nextSecondY][secondX][nextSecondY][secondX] = true;
                    queue.add(new int[]{nextFirstY, firstX, nextSecondY, secondX, count+1});
                }
            }
            for (int i = 2; i < 4; i++) {
                int nextFirstX = firstX + move[i][1];
                int nextSecondX = secondX + move[i][1];

                if (nextFirstX == M || nextFirstX < 0) {
                    if (nextSecondX < M && nextSecondX >= 0) {
                        return count + 1;
                    }
                    continue;
                } else if (nextSecondX == M || nextSecondX < 0) {
                    return count + 1;
                }
                if (board[firstY][nextFirstX] == '#') {
                    nextFirstX = firstX;
                }
                if (board[secondY][nextSecondX] == '#') {
                    nextSecondX = secondX;
                }
                if (!visited[firstY][nextFirstX][secondY][nextSecondX]) {
                    visited[firstY][nextFirstX][secondY][nextSecondX] = true;
                    visited[firstY][nextFirstX][firstY][nextFirstX] = true;
                    visited[secondY][nextSecondX][secondY][nextSecondX] = true;
                    queue.add(new int[]{firstY, nextFirstX, secondY, nextSecondX, count+1});
                }
            }

        }

        return -1;
    }

}
