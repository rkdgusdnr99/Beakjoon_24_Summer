package wrong;

import java.util.*;

public class 숨바꼭질3_13549번_시간초과 {
    static int N, K;
    static boolean[] visited;
    static int max;
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        max = Math.max(N, K);

        visited = new boolean[max + max + 1];

        bfs();

        System.out.println(time);
    }

    static void bfs() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(N);

        while (!visited[K]) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            while (!stack2.isEmpty()) {
                int num = stack2.pop();
                if (num > K) {
                    if (!visited[num-1]) {
                        stack1.push(num-1);
                        visited[num-1] = true;
                    }
                }
                else {
                    for (int i = num*2; i < max*2; i*=2) {
                        if (i >= max * 2 - 1) {
                            break;
                        }
                        if (i == K) {
                            return;
                        }
                        if (!visited[i]) {
                            nextStep(stack1, num, i);
                            visited[i] = true;
                        }
                    }
                    nextStep(stack1, num, num);
                }
            }
            time++;
        }
    }

    private static void nextStep(Stack<Integer> stack1, int num, int i) {
        if (!visited[i+1]) {
            stack1.push(i+1);
            visited[i+1] = true;
        }
        if (num > 0 && !visited[i-1]) {
            stack1.push(i-1);
            visited[i-1] = true;
        }
    }
}
