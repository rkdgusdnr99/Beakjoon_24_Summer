package part1;

import java.util.Scanner;

public class 소수찾기_1978번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(isDecimal(num)) {
                count++;
            }
        }
        System.out.println(count);
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
