package part1;

import java.util.*;

public class 소수_2581번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        long sum = 0;

        for (int i = M; i <= N; i++) {
            if(isDecimal(i)) {
                sum += i;
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(queue.poll());
        }
    }
    private static boolean isDecimal(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
