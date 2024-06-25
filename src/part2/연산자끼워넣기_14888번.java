package part2;

import java.util.*;

public class 연산자끼워넣기_14888번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int[] operatorNum = new int[4];
        for (int i = 0; i < 4; i++) {
            operatorNum[i] = sc.nextInt();
        }
        int[] maxMin = {-1000000000, 1000000000};

        recursion(A, 0, N, operatorNum, A[0], maxMin);

        System.out.println(maxMin[0]);
        System.out.println(maxMin[1]);
    }

    private static void recursion(int[] A, int count, int N, int[] operatorNum,
                                  int sum, int[] maxMin) {
        if (count == N-1) {
            maxMin[0] = Math.max(maxMin[0], sum);
            maxMin[1] = Math.min(maxMin[1], sum);
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (operatorNum[i] > 0) {
                    int[] copyOfOperatorNum = Arrays.copyOf(operatorNum, operatorNum.length);
                    copyOfOperatorNum[i] -= 1;
                    recursion(A, count + 1, N, copyOfOperatorNum, calculation(i, A[count + 1], sum), maxMin);
                }
            }
        }
    }

    private static int calculation(int operatorNum, int num, int sum) {
        if (operatorNum == 0) {
            return sum + num;
        } else if (operatorNum == 1) {
            return sum - num;
        } else if (operatorNum == 2) {
            return sum * num;
        } else {
            return sum / num;
        }
    }
}
