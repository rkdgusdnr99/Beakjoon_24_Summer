package part2;


import java.util.*;

public class 멀티탭스케줄링_1700번 {
    static int N, K;
    static int[] products;
    static boolean[] stuck;
    static int sum = 0;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        products = new int[K];
        stuck = new boolean[K+1];

        for (int i = 0; i < K; i++) {
            products[i] = sc.nextInt();
        }

        unplug();

        System.out.println(sum);
    }

    static void unplug() {
        for (int i = 0; i < K; i++) {
            int num = products[i];
            if (!stuck[num]) {
                if (count < N) { // 일단 다 찰때까지 꽂기
                    count++;
                    stuck[num] = true;
                } else { // 다 찼으면
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        int temp = products[j];
                        if (stuck[temp] && !list.contains(temp)) { //  꽂혀있는 콘센트 중 나중에 사용되지 않는 콘센트 찾기
                            list.add(temp);
                        }
                    }
                    if (list.size() < N) { // 꽂혀있는 콘센트 중 나중에 사용되지 않는 콘센트가 있는 경우
                        for (int j = 0; j < N+1; j++) {
                            if (stuck[j] && !list.contains(j)) {
                                stuck[j] = false;
                                break;
                            }
                        }
                    } else { // 꽂혀있는 모든 콘센트가 사용되는 경우 가장 나중에 사용될 콘센트를 제거
                        stuck[list.get(list.size()-1)] = false;
                    }
                    stuck[num] = true; // 하나 제거가 되었으니 하나 추가
                    sum++; // 뽑은 횟수 1회 추가
                }
            }
        }
    }
}
