package part4;

import java.util.*;

public class 숨바꼭질2_12851번 {
    static int N, K;
    static boolean[] visited;
    static int[] sum;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[K+K];
        sum = new int[K+K];

        bfs();

        System.out.println(count);

        System.out.println(sum[K]);
    }

    static void bfs() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.add(N);
        sum[N] = 1;
        visited[N] = true;

        while (sum[K] == 0) {
            while (!stack1.isEmpty()) {
                int num = stack1.pop();
                if (!visited[num]) {
                    stack2.add(num);
                    visited[num] = true;
                }
            }
            while (!stack2.isEmpty()) {
                int num = stack2.pop();
                if (num > K) {
                    stack1.add(num-1);
                    sum[num-1] += sum[num];
                } else {
                    stack1.add(num+1);
                    sum[num+1] += sum[num];
                    stack1.add(num*2);
                    sum[num*2] += sum[num];
                    if (num > 0) {
                        stack1.add(num-1);
                        sum[num-1] += sum[num];
                    }
                }
            }
            count++;
        }

    }
}
