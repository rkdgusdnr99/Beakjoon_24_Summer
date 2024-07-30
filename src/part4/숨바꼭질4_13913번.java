package part4;

import java.util.*;

public class 숨바꼭질4_13913번 {
    static int N, K;
    static int[] position;
    static int size;
    static int[] time;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        size = Math.min(Math.max(N,K)*2+1, 100001);
        time = new int[size];
        time[N] = 0;
        position = new int[size];
        Arrays.fill(position, -1);

        bfs();
        System.out.println(time[K]);

        Stack<Integer> stack = new Stack<>();
        while (K != N) {
            stack.push(K);
            K = position[K];
        }
        stack.add(N);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == K) {
                return;
            }
            if (num+1 < size && position[num+1] == -1) {
                queue.add(num+1);
                position[num+1] = num;
                time[num+1] = time[num] + 1;
            }
            if (num*2 < size && position[num*2] == -1) {
                queue.add(num*2);
                position[num*2] = num;
                time[num*2] = time[num] + 1;
            }
            if (num-1 >= 0 && position[num-1] == -1) {
                queue.add(num-1);
                position[num-1] = num;
                time[num-1] = time[num] + 1;
            }
        }
    }
}