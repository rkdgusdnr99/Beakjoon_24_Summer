package part5;

import java.util.*;

public class 뮤탈리스크_12869번 {
    static int N;
    static Queue<int[]> queue;
    static int[][] attack = {{9, 3, 1}, {9, 1, 3},
            {3, 9, 1}, {3, 1, 9},
            {1, 9, 3}, {1, 3, 9}};
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        queue = new LinkedList<>();
        visited = new boolean[61][61][61];

        int[] input = new int[4];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        sort(input);
        visited[input[0]][input[1]][input[2]] = true;
        queue.add(input);

        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 6; i++) {
                int[] arr = new int[4];
                arr[0] = scv(temp[0], attack[i][0]);
                arr[1] = scv(temp[1], attack[i][1]);
                arr[2] = scv(temp[2], attack[i][2]);
                arr[3] = temp[3] + 1;

                if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                    return arr[3];
                }

                sort(arr);

                if (!visited[arr[0]][arr[1]][arr[2]]) {
                    queue.add(arr);
                    visited[arr[0]][arr[1]][arr[2]] = true;
                }
            }
        }
        return 0;
    }

    static int scv(int scv, int attack) {
        if (scv > attack) {
            return scv - attack;
        } else {
            return 0;
        }
    }

    static void sort(int[] arr) {
        Integer[] arrCopy = {arr[0], arr[1], arr[2]};
        Arrays.sort(arrCopy, Collections.reverseOrder());
        arr[0] = arrCopy[0];
        arr[1] = arrCopy[1];
        arr[2] = arrCopy[2];
    }
}
