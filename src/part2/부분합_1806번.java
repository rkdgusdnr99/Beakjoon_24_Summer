package part2;

import java.util.*;

public class 부분합_1806번 {
    static int N, K;
    static int min = 100000;
    static int[] sumList;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        sumList = new int[N];
        sumList[0] = sc.nextInt();
        if (sumList[0] >= K) {
            System.out.println(1);
            System.exit(0);
        }

        int bigger = 0;
        boolean find = false;
        for (int i = 1; i < N; i++) {
            int sum = sumList[i-1] + sc.nextInt();
            if (!find && sum >= K) {
                find = true;
                bigger = i;
                min = bigger+1;
            }
            sumList[i] = sum;
        }
        if(!find) {
            System.out.println(0);
            System.exit(0);
        }

        int start = 0;
        for (int i = bigger; i < N; i++) {
            for (int j = start; j < i; j++) {
                if (sumList[i] - sumList[j] >= K) {
                    min = Math.min(i - start, min);
                    start++;
                } else {
                    break;
                }
            }
        }

        System.out.println(min);
    }
}
