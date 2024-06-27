package part2;

import java.util.Scanner;
import java.util.Stack;

public class 빗물_14719번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] wList = new int[W];

        for (int i = 0; i < W; i++) {
            wList[i] = sc.nextInt();
        }

        int maxLeft = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < W; i++) {
            int num = wList[i];
            int min = Math.min(maxLeft , num);
            maxLeft = Math.max(maxLeft , num);
            int count = 0;
            while (!stack.isEmpty() && stack.peek() < min) {
                sum += min - stack.pop();
                count++;
            }
            for (int j = 0; j < count; j++) {
                stack.add(num);
            }
            stack.add(num);
        }

        System.out.println(sum);
    }
}
