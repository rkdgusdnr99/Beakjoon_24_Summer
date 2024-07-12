package part3;

import java.util.Scanner;

public class 수들의합_1789번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        int count = 0;
        int num = 1;
        while (S > 0) {
            S -= num++;
            count++;
        }
        if (S < 0) {
            count--;
        }
        System.out.println(count);
    }
}
