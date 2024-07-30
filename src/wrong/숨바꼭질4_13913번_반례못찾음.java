package wrong;

import java.util.*;

public class 숨바꼭질4_13913번_반례못찾음 {
    static int N, K;
    static int[] position;
    static int size;
    static int time = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        size = Math.min(Math.max(N,K)*2+1, 100001);
        position = new int[size];
        Arrays.fill(position, -1);

        bfs();
        System.out.println(time);

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
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(N);

        while (position[K] == -1) {
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            while (!queue2.isEmpty()) {
                int num = queue2.poll();
                if (num+1 < size && position[num+1] == -1) {
                    position[num+1] = num;
                    queue1.add(num+1);
                }
                if (num*2 < size && position[num*2] == -1) {
                    position[num*2] = num;
                    queue1.add(num*2);
                }
                if (num-1 >= 0 && position[num-1] == -1) {
                    position[num-1] = num;
                    queue1.add(num-1);
                }
            }
            time++;
        }
    }
}