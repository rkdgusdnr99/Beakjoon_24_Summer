package part2;

import java.util.Scanner;

public class 가르침_1062번 {
    static int N,K;
    static String[] words;
    static boolean[] alphabet;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();
        
        if (K < 5) {
            System.out.println(0);
            System.exit(0);
        } else if (K == 26) {
            System.out.println(N);
            System.exit(0);
        }

        words = new String[N];
        alphabet = new boolean[26];

        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            words[i] = input.substring(4, input.length()-4);
        }
        backTracking(0, 0);

        System.out.println(max);
    }

    static void backTracking(int alpha, int count) {
        if (count == K - 5) {
            int num = 0;
            for (int i = 0; i < N; i++) {
                boolean noCost = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!alphabet[words[i].charAt(j) - 'a']) {
                        noCost = false;
                        break;
                    }
                }
                if (noCost) {
                    num ++;
                }
            }
            max = Math.max(max, num);
        }
        for (int i = alpha; i < 26; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                backTracking(i, count+1);
                alphabet[i] = false;
            }
        }
    }
}