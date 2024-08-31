package part5;

import java.util.*;

public class Acka_12996번 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int dotorya = sc.nextInt();
        int kesakiyo = sc.nextInt();
        int hongjun = sc.nextInt();
        int[][][][] dp = new int[S+1][dotorya+1][kesakiyo+1][hongjun+1];

        for (int[][][] arr3d : dp) {
            for (int[][] arr2d : arr3d) {
                for (int[] arr1d : arr2d) {
                    Arrays.fill(arr1d, -1);
                }
            }
        }

        System.out.println(getSum(dp, S, dotorya, kesakiyo, hongjun));
    }

    static int getSum(int[][][][] dp, int S, int dotorya, int kesakiyo, int hongjun) {
        if (S < 0 || dotorya < 0 || kesakiyo < 0 || hongjun < 0) {
            return 0;
        }
        if (S == 0) {
            return (dotorya == 0 && kesakiyo == 0 && hongjun == 0) ? 1 : 0;
        }

        // 메모이제이션: 이미 계산된 경우
        if (dp[S][dotorya][kesakiyo][hongjun] != -1) {
            return dp[S][dotorya][kesakiyo][hongjun];
        }

        int sum = 0;

        // 재귀적으로 각 경우를 탐색하며 sum에 더해줌
        sum = (sum + getSum(dp, S-1, dotorya-1, kesakiyo, hongjun)) % MOD;
        sum = (sum + getSum(dp, S-1, dotorya, kesakiyo-1, hongjun)) % MOD;
        sum = (sum + getSum(dp, S-1, dotorya, kesakiyo, hongjun-1)) % MOD;
        sum = (sum + getSum(dp, S-1, dotorya-1, kesakiyo-1, hongjun)) % MOD;
        sum = (sum + getSum(dp, S-1, dotorya-1, kesakiyo, hongjun-1)) % MOD;
        sum = (sum + getSum(dp, S-1, dotorya, kesakiyo-1, hongjun-1)) % MOD;
        sum = (sum + getSum(dp, S-1, dotorya-1, kesakiyo-1, hongjun-1)) % MOD;

        // 결과를 메모이제이션 테이블에 저장
        dp[S][dotorya][kesakiyo][hongjun] = sum;

        return sum;
    }
}
