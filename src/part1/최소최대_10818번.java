package part1;

import java.util.Scanner;

public class 최소최대_10818번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String numString = sc.nextLine();
        String[] numList = numString.split(" ");
        int min = 1000000;
        int max = -1000000;
        for (int i = 0; i < N; i++) {
             int num = Integer.parseInt(numList[i]);
             if (num < min) {
                 min = num;
             }
             if (num > max) {
                 max = num;
             }
        }
        System.out.println(min + " " + max);
    }
}
