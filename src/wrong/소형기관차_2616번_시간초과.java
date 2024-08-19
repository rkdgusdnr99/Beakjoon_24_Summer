package wrong;

import java.util.*;

public class 소형기관차_2616번_시간초과 {
    static int N;
    static int[] cars;
    static int M;
    static int[] dp;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cars = new int[N];
        for (int i = 0; i < N; i++) {
            cars[i] = sc.nextInt();
        }
        M = sc.nextInt();

        dp = new int[N-M+1];
        for (int i = 0; i <= N-M; i++) {
            dp[i] = addCars(i);
        }

        findMax();

        System.out.println(max);
    }

    static void findMax() {
        for (int i = 0; i <= N-M*3; i++) {
            for (int j = i+M; j <= N-M*2; j++) {
                for (int k = j+M; k <= N-M; k++) {
                    max = Math.max(max, dp[i] + dp[j] + dp[k]);
                }
            }
        }
    }

    static int addCars(int start) {
        int sum = 0;
        for (int i = start; i < start + M; i++) {
            sum += cars[i];
        }
        return sum;
    }
}
