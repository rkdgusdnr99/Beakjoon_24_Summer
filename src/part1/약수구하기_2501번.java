package part1;

import java.util.Scanner;

public class 약수구하기_2501번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nk = sc.nextLine();
        String[] spiltNK = nk.split(" ");

        int N = Integer.parseInt(spiltNK[0]);
        int K = Integer.parseInt(spiltNK[1]);

        for (int i = 1; i <= N/2; i++) {
            if(N % i == 0) {
                K--;
                if(K == 0) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }

        if (K == 1) {
            System.out.println(N);
        }
        else {
            System.out.println(0);
        }
    }
}