package wrong;

import java.util.Scanner;
import java.util.Stack;

public class 숨바꼭질2_12851번_메모리초과 {
    static int N, K;
    static int sum = 0;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        bfs();

        System.out.println(count);

        System.out.println(sum);
    }

    static void bfs() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.add(N);

        while (sum == 0) {
            while (!stack1.isEmpty()) {
                int num = stack1.pop();
                if (num == K) {
                    sum++;
                    while (!stack1.isEmpty()) {
                        if (stack1.pop() == K) {
                            sum++;
                        }
                    }
                    return;
                }
                stack2.add(num);
            }
            while (!stack2.isEmpty()) {
                int num = stack2.pop();
                if (num > K) {
                    stack1.add(num-1);
                } else {
                    stack1.add(num+1);
                    stack1.add(num*2);
                    if (num > 0) {
                        stack1.add(num-1);
                    }
                }
            }
            count++;
        }
    }
}
