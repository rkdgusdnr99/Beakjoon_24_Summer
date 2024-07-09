package wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열_16916번_시간초과2 {
    static String S, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();

        if (S.contains(P)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
