package wrong;


import java.util.Scanner;

public class 멀티탭스케줄링_1700번_시간초과 {
    static int N, K;
    static int[] products;
    static boolean[] stuck;
    static int min = 100;
    static int[] consent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        products = new int[K];
        stuck = new boolean[K+1];
        consent = new int[N];

        for (int i = 0; i < K; i++) {
            products[i] = sc.nextInt();
        }
        unplug(0,0,0);

        System.out.println(min);
    }

    static void unplug(int start, int count, int sum) {
        if (sum >= min) {
            return;
        }
        for (int i = start; i < K; i++) {
            int num = products[i];
            if (stuck[num]) {
                start++;
                continue;
            }
            if (count == N) {
                for (int j = 0; j < N; j++) {
                    int temp = consent[j];
                    consent[j] = products[i];
                    stuck[products[i]] = true;
                    stuck[temp] = false;
                    unplug(start+1, count, sum+1);
                    consent[j] = temp;
                    stuck[products[i]] = false;
                    stuck[temp] = true;
                }
                return;
            } else {
                consent[count++] = num;
                stuck[products[i]] = true;
                start++;
            }
        }
        min = sum;
    }


}
