package part6;

import java.io.*;
import java.util.*;

// Coin 클래스는 동전의 위치, 움직임을 담당
class Coin {
    int y;
    int x;

    Coin(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public Coin move(int dy, int dx, Board board) {
        int nextY = y + dy;
        int nextX = x + dx;

        if (board.isOutOfBounds(nextY, nextX)) {
            return null; // 경계를 벗어나면 null 반환
        }

        if (board.isWall(nextY, nextX)) {
            return new Coin(y, x); // 벽을 만나면 이동하지 않음
        }

        return new Coin(nextY, nextX); // 새로운 위치 반환
    }
}

// Board 클래스는 판의 모양, 기록를 알려줌
class Board {
    char[][] board;
    boolean[][][][] visited;
    int N, M;

    Board(char[][] board, int N, int M) {
        this.board = board;
        this.N = N;
        this.M = M;
        visited = new boolean[N][M][N][M];
    }

    boolean isOutOfBounds(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= M;
    }

    boolean isWall(int y, int x) {
        return board[y][x] == '#';
    }

    boolean isVisited(Coin coin1, Coin coin2) {
        return visited[coin1.y][coin1.x][coin2.y][coin2.x];
    }

    void markVisited(Coin coin1, Coin coin2) { // 중복 방지
        visited[coin1.y][coin1.x][coin2.y][coin2.x] = true;
        visited[coin2.y][coin2.x][coin1.y][coin1.x] = true;
        visited[coin1.y][coin1.x][coin1.y][coin1.x] = true;
        visited[coin2.y][coin2.x][coin2.y][coin2.x] = true;
    }
}

public class 두동전_16197번 {

    static int[][] move = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        Coin[] coins = new Coin[2];
        char[][] board = new char[N][M];
        int coinIndex = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'o') { // 동전 발견 시 위치 저장
                    coins[coinIndex] = new Coin(i, j);
                    coinIndex++;
                }
            }
        }

        Board realBoard = new Board(board, N, M);

        System.out.println(dropCoin(coins, realBoard));
    }

    static int dropCoin(Coin[] coins, Board board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{coins[0].y, coins[0].x, coins[1].y, coins[1].x, 0}); // 코인 위치, 이동 횟수 기록
        board.markVisited(coins[0], coins[1]); // 첫 위치 기록

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int coin1Y = now[0];
            int coin1X = now[1];
            int coin2Y = now[2];
            int coin2X = now[3];
            int count = now[4];

            if (count == 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                Coin nextCoin1 = new Coin(coin1Y, coin1X);
                Coin nextCoin2 = new Coin(coin2Y, coin2X);

                // 두 코인 모두 움직여봄
                nextCoin1 = nextCoin1.move(move[i][0], move[i][1], board);
                nextCoin2 = nextCoin2.move(move[i][0], move[i][1], board);

                if ((nextCoin1 == null && nextCoin2 != null )
                        || (nextCoin1 != null && nextCoin2 == null)) { // 둘 중 하나 떨어짐
                    return count + 1;
                }

                if (nextCoin1 != null && nextCoin2 != null) { // 둘다 떨어지지 않은 경우
                    if (!board.isVisited(nextCoin1, nextCoin2)) {
                        board.markVisited(nextCoin1, nextCoin2);
                        queue.add(new int[]{nextCoin1.y, nextCoin1.x, nextCoin2.y, nextCoin2.x, count + 1});
                    }
                }
            }

        }
        return -1; // queue가 비면 -1 반환(경우의 수 없음)
    }

}
