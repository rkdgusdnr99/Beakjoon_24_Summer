package part1;

import java.util.Scanner;

public class 이진수_3460번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] num = new int[T];
        for (int i = 0; i < T; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            int one = 0;
            while (num[i] > 0) {
                if (num[i] % 2 == 1) {
                    System.out.print(one + " ");
                }
                num[i] /= 2;
                one++;
            }
            System.out.println();
        }
    }
}
