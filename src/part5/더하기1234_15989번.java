package part5;

import java.util.*;

public class 더하기1234_15989번 {
    static int T;
    static Queue<Integer> queue;
    static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        queue = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            queue.add(sc.nextInt());
        }

        count = new int[10001];
        count[1] = 1;
        count[2] = 2;
        count[3] = 3;

        oneTwoThree();

        while (!queue.isEmpty()) {
            System.out.println(count[queue.poll()]);
        }

    }

    static void oneTwoThree() {
        int even = 1;
        int odd = 1;
        for (int i = 4; i <= 10000; i++) {
            if (i % 3 == 0) {
                if (even > odd) {
                    odd++;
                } else {
                    even++;
                }
            }

            if (i % 2 == 0) {
                count[i] = count[i-1] + even;
            } else {
                count[i] = count[i-1] + odd;
            }
        }
    }

}
