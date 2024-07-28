package part4;

import java.util.Scanner;

public class AtoB_16953번 {
    static int A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println(AtoB(B, 1));
    }

    static int AtoB(int num, int count) {
        while (num > A) {
            num = One(num);
            count++;
        }
        if (num == A) {
            return count;
        } else {
            return -1;
        }
    }

    static int One(int num) {
        if (num % 10 == 1) {
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
