package CodingTest;

import java.util.Scanner;

public class 동전0_11047번 {
    static int N, K;
    static int[] coins;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        coins = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
            if (coins[i] <= K) {
                max = i;
            }
        }

        int sum = 0;
        while (K > 0) {
            sum += K / coins[max];
            K %= coins[max--];
        }

        System.out.println(sum);

    }
}
