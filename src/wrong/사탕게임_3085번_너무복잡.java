package wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Continuous implements Comparable<Continuous> {
    char word;
    int start;
    int end;
    int len;

    public Continuous(char word, int len, int end) {
        this.word = word;
        this.start = end - len + 1;
        this.end = end;
        this.len = len;
    }

    @Override
    public int compareTo(Continuous other) {
        return Integer.compare(this.len, other.len);
    }
}

public class 사탕게임_3085번_너무복잡 {
    static int N;
    static char[][] candy;
    static PriorityQueue<Continuous> row;
    static PriorityQueue<Continuous> column;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        candy = new char[N][N];
        for (int i = N - 1; i >= 0; i--) {
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                candy[i][j] = line.charAt(j);
            }
        }

        row = new PriorityQueue<>();
        column = new PriorityQueue<>();

        candyRow();
        candyColumn();

        System.out.println(max);
    }

    static void candyRow() {
        for (int i = N-1; i >= 0; i--) { // 행에서 연속되는 사탕의 수
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (candy[i][j] == candy[i][j-1]) {
                    count++;
                } else {
                    if (count > 1) {
                        row.add(new Continuous(candy[i][j-1], count, j-1));
                        max = Math.max(count, max);
                    }
                    count = 1;
                }
            }
            if (count != 1) {
                row.add(new Continuous(candy[i][N-1], count, N-1));
                max = Math.max(count, max);
            }
            if (max == N) {
                System.out.println(N);
                System.exit(0);
            }
            if (i == N-1) {

            } else if (i == 0) {

            } else {
                for (Continuous continuous : row) {
                    int sum = continuous.len;
                    char word = continuous.word;
                    int start = continuous.start;
                    int end = continuous.end;
                    if (start == 0) {

                    } else if (end == N-1) {

                    }
                    else {
                        if (candy[i+1][start-1] == word || candy[i-1][start-1] == word) {
                            sum++;
                            for (int j = start - 2; j >= 0 ; j--) {
                                if (candy[i+1][j] == word || candy[i-1][j] == word) {
                                    sum++;
                                }
                                else {
                                    break;
                                }
                            }
                            max = Math.max(sum, max);
                        }
                    }
                }
            }
        }


    }

    static void candyColumn() {
        for (int i = N-1; i >= 0; i--) { // 열에서 연속되는 사탕의 수
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (candy[j][i] == candy[j-1][i]) {
                    count++;
                } else {
                    if (count > 1) {
                        column.add(new Continuous(candy[j-1][i], count, j-1));
                        max = Math.max(count, max);
                    }
                    count = 1;
                }
            }
            if (count != 1) {
                column.add(new Continuous(candy[N-1][i], count, N-1));
                max = Math.max(count, max);
            }
            if (max == N) {
                System.out.println(N);
                System.exit(0);
            }
        }
    }


}
