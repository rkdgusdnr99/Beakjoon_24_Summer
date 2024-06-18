package part1;

import java.util.Scanner;

public class 지능형기차2_2460번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int num = 0;
        for (int i = 0; i < 10; i++) {
            String input = sc.nextLine();
            String[] inputList = input.split(" ");
            num -= Integer.parseInt(inputList[0]);
            num += Integer.parseInt(inputList[1]);
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
    }
}
