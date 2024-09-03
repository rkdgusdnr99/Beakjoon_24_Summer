package wrong;

import java.util.Scanner;

public class 출근기록_14238번_시간초과 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int A = 0;
        int B = 0;
        int C = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                A++;
            } else if (S.charAt(i) == 'B') {
                B++;
            } else {
                C++;
            }
        }

        dfs(A, B, C, "", S.length(), 0, 0);

        System.out.println(-1);

    }

    static void dfs(int A, int B, int C, String S, int count, int bCount, int cCount) {
        if (count == 0) {
            System.out.println(S);
            System.exit(0);
        }

        if (bCount == 0 && cCount == 0) {
            if (A > 0) {
                dfs(A - 1, B, C, S + "A", count - 1, 0, 0);
            }
            if (B > 0) {
                dfs(A, B - 1, C, S + "B", count - 1, 1, cCount);
            }
            if (C > 0) {
                dfs(A, B, C, S + "C", count - 1, 0, 2);
            }
        } else if (bCount > 0 && cCount > 0) {
            if (A > 0) {
                dfs(A - 1, B, C, S + "A", count - 1, 0, 0);
            }
        } else if (bCount > 0) {
            if (A > 0) {
                dfs(A - 1, B, C, S + "A", count - 1, 0, 0);
            }
            if (C > 0) {
                dfs(A, B, C, S + "C", count - 1, 0, 2);
            }
        } else if (cCount > 0) {
            if (A > 0) {
                dfs(A - 1, B, C, S + "A", count - 1, 0, cCount-1);
            }
            if (B > 0) {
                dfs(A, B - 1, C, S + "B", count - 1, 1, cCount-1);
            }
        }

    }
}
