package part5;

import java.io.*;
import java.util.*;

public class BOJ거리_12026번 {
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N];
        List<Integer> bList = new ArrayList<>();
        List<Integer> oList = new ArrayList<>();
        List<Integer> jList = new ArrayList<>();

        char[] chars = br.readLine().toCharArray();
        char first = chars[0];
        if (first == 'B') {
            bList.add(0);
        } else {
            System.out.println(-1);
            System.exit(0);
        }

        for (int i = 1; i < N; i++) {
            char c = chars[i];
            if (c == 'B') {
                dp[i] = findMin(bList, jList, i);
            } else if (c == 'O') {
                dp[i] = findMin(oList, bList, i);
            } else if (c == 'J') {
                dp[i] = findMin(jList, oList, i);
            }
        }

        System.out.println(dp[N-1]);
    }

    static long findMin(List<Integer> now, List<Integer> before, int i) {
        long min = -1;
        if (!before.isEmpty()) {
            now.add(i);
            int size = before.size();
            min = dp[before.get(size-1)]
                    + (long)(i - before.get(size - 1)) * (i - before.get(size-1));
            for (int j = before.size()-2; j >= 0 ; j--) {
                long temp = dp[before.get(j)] + (long)(i - before.get(j)) * (i - before.get(j));
                if (min > temp) {
                    min = temp;
                }
            }
        }
        return min;
    }
}
