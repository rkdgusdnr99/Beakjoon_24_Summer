package CodingTest;

import java.io.*;
import java.util.*;

public class 프린터큐_1966번 {
    static int testCase;
    static Queue<int[]> queue;
    static Queue<Integer> print;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        print = new LinkedList<>();
        for (int i = 0; i < testCase; i++) {
            queue = new LinkedList<>();
            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int K = Integer.parseInt(firstLine[1]);

            String[] secondLine = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                queue.add(new int[]{j, Integer.parseInt(secondLine[j])});
            }

            int num = 0;
            while (!queue.isEmpty()) {
                boolean isBigger = false;
                int[] cur = queue.poll();
                for (int[] arr : queue) {
                    if (arr[1] > cur[1]) {
                        isBigger = true;
                        break;
                    }
                }
                if (isBigger) {
                    queue.add(cur);
                } else {
                    num++;
                    if (cur[0] == K) {
                        print.add(num);
                        break;
                    }
                }
            }
        }
        while (!print.isEmpty()) {
            System.out.println(print.poll());
        }
    }


}
