package part1;

import java.util.*;

public class N번째큰수_2693번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            int[] tenNum = new int[10];
            for (int j = 0; j < 10; j++) {
                tenNum[j] = sc.nextInt();
            }
            queue.add(quickSort(tenNum,0,9));
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    static int quickSort(int[] num, int left, int right) {
        int le = left;
        int ri = right;
        int pivot = num[(le + ri) / 2];

        do {
            while (num[le] < pivot) {
                le++;
            }
            while (num[ri] > pivot) {
                ri--;
            }
            if (le <= ri) {
                swap(num, le++, ri--);
            }
        } while (le <= ri);

        if (left < ri) {
            quickSort(num, left, ri);
        }
        if (le < right) {
            quickSort(num, le, right);
        }
        return num[7];
    }

    static void swap(int[] num, int le, int ri) {
        int temp = num[le];
        num[le] = num[ri];
        num[ri] = temp;
    }
}
