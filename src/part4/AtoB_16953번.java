package part4;

import java.util.Scanner;

public class AtoB_16953번 {
    static int A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        AtoB(B, 1);
    }

    static void AtoB(int num, int count) {
        while (num > A) {
            num = One(num);
            count++;
        }
        if (num == A) {
            System.out.println(count);
            System.exit(0);
        } else {
            System.out.println(-1);
            System.exit(0);
        }
    }

    static int One(int num) {
        if ((num - 1) % 10 == 0) {
            return (num - 1) / 10;
        } else {
            return Two(num);
        }
    }

    static int Two(int num) {
        if (num % 2 == 0) {
            return num / 2;
        }
        return 0;
    }
}
