package part4;

import java.util.*;

public class 숨바꼭질2_12851번 {
    static int N, K;
    static int[] sum;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        int max = Math.max(N, K);

        sum = new int[max + max];
        visited = new boolean[max + max];

        bfs();

        System.out.println(count);

        System.out.println(sum[K]);
    }

    static void bfs() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(N);
        sum[N] = 1;

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
                    if (!visited[num-1]) {
                        sum[num-1] += sum[num];
                        stack1.push(num-1);
                    }
                }
                else {
                    if (!visited[num+1]) {
                        sum[num+1] += sum[num];
                        stack1.push(num+1);
                    }
                    if (!visited[num*2]) {
                        sum[num*2] += sum[num];
                        stack1.push(num*2);
                    }
                    if (num > 0 && !visited[num-1]) {
                        sum[num-1] += sum[num];
                        stack1.push(num-1);
                    }
                }
            }
            count++;
        }

    }
}
