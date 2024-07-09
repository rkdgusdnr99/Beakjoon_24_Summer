package wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 부분문자열_16916번_시간초과 {
    static String S, P;
    static int sLen, pLen;
    static char pStart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();

        sLen = S.length();
        pLen = P.length();

        pStart = P.charAt(0);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (pStart == S.charAt(i)) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (start + pLen > sLen) {
                System.out.println(0);
                System.exit(0);
            }

            if (S.substring(start, start+pLen).equals(P)) {
                System.out.println(1);
                System.exit(0);
            }
        }

        System.out.println(0);
    }
}
