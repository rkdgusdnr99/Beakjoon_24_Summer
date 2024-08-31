package wrong;

import java.util.Scanner;

public class Acka_12996번_시간초과 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int dotorya = sc.nextInt();
        int kesakiyo = sc.nextInt();
        int hongjun = sc.nextInt();

        System.out.println(getSum(S, dotorya, kesakiyo, hongjun));
    }

    static int getSum(int S, int dotorya, int kesakiyo, int hongjun) {
        if (S > dotorya + kesakiyo + hongjun) {
            return 0;
        }
        if (S == 0) {
            return (dotorya == 0 && kesakiyo == 0 && hongjun == 0) ? 1 : 0;
        }
        int sum = 0;
        if (dotorya > 0) {
            sum = (sum + getSum(S-1, dotorya-1, kesakiyo, hongjun)) % MOD;
        }
        if (kesakiyo > 0) {
            sum = (sum + getSum(S-1, dotorya, kesakiyo-1, hongjun)) % MOD;
        }
        if (hongjun > 0) {
            sum = (sum + getSum(S-1, dotorya, kesakiyo, hongjun-1)) % MOD;
        }
        if (dotorya > 0 && kesakiyo > 0) {
            sum = (sum + getSum(S-1, dotorya-1, kesakiyo-1, hongjun)) % MOD;
        }
        if (dotorya > 0 && hongjun > 0) {
            sum = (sum + getSum(S-1, dotorya-1, kesakiyo, hongjun-1)) % MOD;
        }
        if (kesakiyo > 0 && hongjun > 0) {
            sum = (sum + getSum(S-1, dotorya, kesakiyo-1, hongjun-1)) % MOD;
        }
        if (dotorya > 0 && kesakiyo > 0 && hongjun > 0) {
            sum = (sum + getSum(S-1, dotorya-1, kesakiyo-1, hongjun-1)) % MOD;
        }

        return sum;
    }
}
