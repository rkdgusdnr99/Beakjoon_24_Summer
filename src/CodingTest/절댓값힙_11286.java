package CodingTest;

import java.util.PriorityQueue;
import java.util.Scanner;

class Absolute implements Comparable<Absolute>{
    int num;
    public Absolute(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Absolute o) {
        int thisAbs = Math.abs(this.num);
        int oAbs = Math.abs(o.num);

        if (thisAbs != oAbs) {
            return thisAbs - oAbs; // 절댓값 기준 정렬
        } else {
            return this.num - o.num; // 절댓값이 같을 때 원래 값 기준 정렬
        }
    }

}

public class 절댓값힙_11286 {
    static int N;
    static PriorityQueue<Absolute> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().num);
                }
            } else {
                Absolute absolute = new Absolute(num);
                pq.add(absolute);
            }
        }
    }
}
