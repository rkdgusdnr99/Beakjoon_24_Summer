package part5;

import java.util.*;

public class 출근기록_14238번 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int len = S.length();

        int A = 0;
        int B = 0;
        int C = 0;

        for (int i = 0; i < len; i++) { // A, B, C 수 체크
            if (S.charAt(i) == 'A') {
                A++;
            } else if (S.charAt(i) == 'B') {
                B++;
            } else {
                C++;
            }
        }

        // dp[한칸 뒤 문자][두칸 뒤 문자][남은 A][남은 B][남은 C]
        boolean[][][][][] dp = new boolean[4][4][A+1][B+1][C+1];

        dfs(0, 0, A, B, C, dp, "");
        System.out.println(-1);

    }

    static void dfs(int back, int backBack, int A, int B, int C, boolean[][][][][] dp, String S) {
        if (A + B + C == 0) { // 모든 문자를 다 사용했다면
            System.out.println(S);
            System.exit(0);
        }

        // 중복체크
        if (dp[back][backBack][A][B][C]) {
            return;
        }
        dp[back][backBack][A][B][C] = true;

        if (backBack == 3) { // 두칸 뒤에 C가 있을 때
            if (back == 2) { // 한칸 뒤에 B가 있을 때
                if (A > 0) {
                    dfs(1, back, A-1, B, C, dp, S + "A");
                }
            } else { // 한칸 뒤에 A가 있을 때
                if (A > 0) {
                    dfs(1, back, A-1, B, C, dp, S + "A");
                }
                if (B > 0) {
                    dfs(2, back, A, B-1, C, dp, S + "B");
                }
            }
        } else { // 두칸 뒤에 C가 있지 않다면
            if (back == 3) { // 한칸 뒤에 C가 있을 때
                if (A > 0) {
                    dfs(1, back, A-1, B, C, dp, S + "A");
                }
                if (B > 0) {
                    dfs(2, back, A, B-1, C, dp, S + "B");
                }
            } else if (back == 2){ // 한칸 뒤에 B가 있을 때
                if (A > 0) {
                    dfs(1, back, A-1, B, C, dp, S + "A");
                }
                if (C > 0) {
                    dfs(3, back, A, B, C-1, dp, S + "C");
                }
            } else { // 한칸 뒤에 A또는 아무것도 없을 때
                if (A > 0) {
                    dfs(1, back, A-1, B, C, dp, S + "A");
                }
                if (B > 0) {
                    dfs(2, back, A, B-1, C, dp, S + "B");
                }
                if (C > 0) {
                    dfs(3, back, A, B, C-1, dp, S + "C");
                }
            }
        }
    }
}
