package part5;

import java.util.*;

public class 기타리스트_1495번 {
    static int N, S, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt(); // 초기값
        M = sc.nextInt(); // 최댓값

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(S);

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            TreeSet<Integer> nextSet = new TreeSet<>();

            while (!treeSet.isEmpty()){
                int temp = treeSet.pollFirst();
                if (temp + num <= M) {
                    nextSet.add(temp + num);
                }
                if (temp - num >= 0) {
                    nextSet.add(temp - num);
                }
            }

            treeSet = nextSet;

            if (treeSet.isEmpty()) {
                treeSet.add(-1);
                break;
            }
        }
        System.out.println(treeSet.last());
    }
}
