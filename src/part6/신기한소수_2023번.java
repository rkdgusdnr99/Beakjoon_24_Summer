package part6;

import java.util.*;

public class 신기한소수_2023번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 2, 3, 5, 7로 시작해야 함
        // 이후 0, 2, 4, 5, 6, 8은 나올 수 없음
        // 그렇다면 짝수로 나눠볼 필요가 없어짐
        int[] next = new int[]{1, 3, 7, 9};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(7);

        while(!queue.isEmpty()) {
            int num = queue.poll();
            if ((int)Math.log10(num) + 1 == N) { // 자리수에 도달
                System.out.println(num);
                while (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                }
                break;
            }

            for (int i = 0; i < 4; i++) {
                int prime = num * 10 + next[i];
                if (isPrime(prime)) {
                    queue.add(prime);
                }
            }
        }
    }

    static boolean isPrime(int n) {
        for (int i = 3; i <= n/3; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
