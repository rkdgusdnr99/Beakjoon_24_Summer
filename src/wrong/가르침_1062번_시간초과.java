package wrong;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 가르침_1062번_시간초과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        if (K < 5) {
        System.out.println(0);
            System.exit(0);
        } else if (K == 26) {
        System.out.println(N);
            System.exit(0);
        }

        Set<Character> hashset = new HashSet<>();
        hashset.add('a');
        hashset.add('n');
        hashset.add('t');
        hashset.add('i');
        hashset.add('c');

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            words[i] = input.substring(4, input.length()-4);
        }

        AtomicInteger max = new AtomicInteger(0);
        recursion(hashset, N, K-5, words, 0, 0, max);
        System.out.println(max);
    }

    static void recursion(Set<Character> hashset, int N, int K, String words[], int count, int num,  AtomicInteger max) {
        for (int i = count; i < N; i++) {
            Set<Character> copySet = new HashSet<>(hashset);
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                copySet.add(word.charAt(j));
            }
            int size = copySet.size() - hashset.size();
            if (size <= K) {
                recursion(copySet, N, K-size, words, i+1, num+1, max);
            }
        }
        max.set(Math.max(max.get(), num));
    }
}