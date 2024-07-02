package wrong;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 멀티탭스케줄링_1700번_메모리초과 {
    static int N, K;
    static int[] products;
    static int min = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        products = new int[K];

        for (int i = 0; i < K; i++) {
            products[i] = sc.nextInt();
        }

        Set<Integer> hashSet = new HashSet<>();
        unplug(0, 0, hashSet);

        System.out.println(min);
    }

    private static void unplug(int start, int sum, Set<Integer> hashSet) {
        while (start < K) {
            hashSet.add(products[start++]);
            if (hashSet.size() == N + 1) {
                hashSet.remove(products[--start]);
                break;
            }
        }
        if (start == K) {
            min = Math.min(sum, min);
        }
        else {
            ArrayList<Integer> list = new ArrayList<>(hashSet);
            Set<Integer> copySet = new HashSet<>(hashSet);
            for (int i = 0; i < N; i++) {
                int num = list.get(i);
                copySet.remove(num);
                unplug(start, sum+1, copySet);
                copySet.add(num);
            }
        }
    }
}
