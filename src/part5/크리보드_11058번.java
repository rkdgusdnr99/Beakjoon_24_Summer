package part5;

import java.util.Scanner;

public class 크리보드_11058번 {
    static int N;
    static long[] criBoard;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        criBoard = new long[N+1];
        for (int i = 1; i <= Math.min(6,N); i++) {
            criBoard[i] = i;
        }

        findMax();
        System.out.println(criBoard[N]);
    }

    static void findMax() {
        for (int i = 7; i <= N; i++) {
            criBoard[i] = Math.max(criBoard[i-5]*4, criBoard[i-4]*3);
        }
    }
}
