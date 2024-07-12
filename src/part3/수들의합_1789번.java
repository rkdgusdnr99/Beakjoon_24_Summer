package part3;

import java.util.Scanner;

public class 수들의합_1789번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        int num = 1;
        while (2 * S / num > num + 1) {
            num++;
        }
        if (2 * S / num < num + 1) {
            num--;
        }
        System.out.println(num);
    }
}
