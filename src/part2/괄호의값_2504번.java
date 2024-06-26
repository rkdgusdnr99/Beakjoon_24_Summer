package part2;

import java.util.*;

public class 괄호의값_2504번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        int[] sumList = new int[30];
        Arrays.fill(sumList, 1);
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);
            if (bracket == '(') {
                stack.add(2);
                count++;
            } else if (bracket == '[') {
                stack.add(3);
                count++;
            } else if (bracket == ')') {
                if (stack.isEmpty() || stack.pop() != 2) {
                    System.out.println(0);
                    System.exit(0);
                }
                count--;
                if (sumList[count] == 1) {
                    sumList[count] = 2 * sumList[count + 1];
                    sumList[count + 1] = 1;
                } else {
                    sumList[count] += 2 * sumList[count + 1];
                    sumList[count + 1] = 1;
                }
            } else {
                if (stack.isEmpty() || stack.pop() != 3) {
                    System.out.println(0);
                    System.exit(0);
                }
                count--;
                if (sumList[count] == 1) {
                    sumList[count] = 3 * sumList[count + 1];
                    sumList[count + 1] = 1;
                } else {
                    sumList[count] += 3 * sumList[count + 1];
                    sumList[count + 1] = 1;
                }
            }

        }
        if (!stack.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(sumList[0]);
    }
}
