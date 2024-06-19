package part1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 최대공약수와최소공배수_2609번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fir = sc.nextInt();
        int sec = sc.nextInt();
        int min = Math.min(fir, sec);
        int max = Math.max(fir, sec);

        Set<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <= min/2; i++) {
            if (min % i == 0) {
                hashSet.add(i);
            }
        }
        hashSet.add(min);

        for (int i = min; i >= 1; i--) {
            int size = hashSet.size();
            if (max % i == 0) {
                hashSet.add(i);
                if (size == hashSet.size()) {
                    System.out.println(i);
                    break;
                }
            }
        }

        long lcm = max;
        while (lcm % min != 0) {
            lcm += max;
        }
        System.out.println(lcm);
    }
}
