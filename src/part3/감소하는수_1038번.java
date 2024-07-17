package part3;

import java.util.*;

public class 감소하는수_1038번 {
    static int N;
    static ArrayList<Long> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new ArrayList<>();
        if (N <= 10) {
            System.out.println(N);
        }
        else {
            list.add(0L);
            for (int i = 1; i < 10; i++) {
                bp(i,1);
            }
            Collections.sort(list);
            if (N >= list.size()) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(N));
            }
        }
    }
    static void bp(long num, int idx) {
        if (idx > 10) {
            return;
        }
        list.add(num);
        int remain = (int)(num % 10);
        if (remain == 0) {
            return;
        }
        for (int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }
}
