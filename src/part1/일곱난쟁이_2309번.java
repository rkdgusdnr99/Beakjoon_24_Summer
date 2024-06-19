package part1;

import java.util.*;

public class 일곱난쟁이_2309번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            numbers.add(num);
            sum += num;
        }

        boolean fin = false;
        for (int i = 0; i < 8; i++) {
            sum -= numbers.get(i);
            for (int j = i+1; j < 9; j++) {
                sum-= numbers.get(j);
                if (sum == 100) {
                    numbers.remove(j);
                    numbers.remove(i);
                    fin = true;
                    break;
                }
                sum += numbers.get(j);
            }
            if (fin) {
                break;
            }
            sum += numbers.get(i);
        }

        Collections.sort(numbers);

        for (int i = 0; i < 7; i++) {
            System.out.println(numbers.get(i));
        }
    }
}
