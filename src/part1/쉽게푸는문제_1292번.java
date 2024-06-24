package part1;

import java.util.*;

public class 쉽게푸는문제_1292번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int count = 1;
        int sum = 0;

        while (count <= end) {
            num++;
            for (int i = 0; i < num; i++) {
                queue.add(num);
                stack.add(num);
                sum += num;
                count++;
            }
        }
        for (int i = 1; i < start; i++) {
            sum -= queue.poll();
        }
        for (int i = count-1; i > end; i--) {
            sum -= stack.pop();
        }
        System.out.println(sum);
    }
}

