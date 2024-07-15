package wrong;

import java.util.*;

public class 동전1_2293번_시간초과 {
    static int n, k;
    static int count = 0;
    static int[] coins;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        coins = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            coins[i] = queue.poll();
        }

        recursion(n-1, 0);

        System.out.println(count);
    }

    static void recursion(int temp, int sum) {
        if (temp < 0) {
            return;
        }
        while (sum < k) {
            recursion(temp-1, sum);
            sum += coins[temp];
        }
        if (sum == k) {
            count++;
        }
    }
}
