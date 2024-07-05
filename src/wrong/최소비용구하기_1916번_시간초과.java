package wrong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최소비용구하기_1916번_시간초과 {
    static int N, M;
    static List<Integer>[] listArray;
    static int[][] fees;
    static boolean[] visited;
    static int start, end;
    static int min = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        listArray = new List[N+1];
        for (int i = 0; i <= N; i++) {
            listArray[i] = new ArrayList<>();
        }
        fees = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int fee = sc.nextInt();
            listArray[s].add(e);
            fees[s][e] = fee;
        }
        start = sc.nextInt();
        end = sc.nextInt();

        visited = new boolean[N+1];
        visited[start] = true;
        minimumCost(start, 0);

        System.out.println(min);

    }

    static void minimumCost(int city, int sum) {
        if (sum >= min) {
            return;
        }
        if (city == end) {
            min = Math.min(sum, min);
        }
        for (int i = 0; i < listArray[city].size(); i++) {
            int next = listArray[city].get(i);
            if(!visited[next]) {
                visited[next] = true;
                minimumCost(next, sum + fees[city][next]);
                visited[next] = false;
            }
        }
    }
}
