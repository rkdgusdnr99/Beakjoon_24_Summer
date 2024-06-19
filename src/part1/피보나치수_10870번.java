package part1;

import java.util.Scanner;

public class 피보나치수_10870번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 1) {
            System.out.println(1);
            System.exit(0);
        }
        if(n == 0) {
            System.out.println(0);
            System.exit(0);
        }

        long min = 0;
        long max = 1;
        for (int i = 1; i < n; i++) {
            long temp = max;
            max += min;
            min = temp;
        }
        System.out.println(max);
    }
}
