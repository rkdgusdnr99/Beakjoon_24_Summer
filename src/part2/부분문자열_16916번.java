package part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열_16916번 {
    static int[] table;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        makeTable(p);

        System.out.println(search(s, p));
    }

    public static int search(String str, String pattern) {
        int sLen = str.length();
        int pLen = pattern.length();

        int index = 0;
        for(int i = 0; i < sLen; i++) {
            /*
            * 아래서 설명하는 바와 같이 실패함수를 이용한 방식
            * table[]을 더이상 갱신하지 않고, 이용해주기만 한다.
            * 이로써 패턴 분석이 가능해지고, 중복 검사를 획기적으로 줄일 수 있다.*/
            while(index > 0 && str.charAt(i) != pattern.charAt(index)) {
                index = table[index - 1];
            }

            if(str.charAt(i) == pattern.charAt(index)) {

                if(index == pLen - 1) { // 같은 숫자의 문자열이 일치한다는 뜻
                    return 1;
                }
                else {
                    index++;
                }
            }
        }
        return 0;
    }

    public static void makeTable(String pattern) {
        int pLen = pattern.length();
        table = new int[pLen];

        int index = 0;
        for(int i = 1; i < pLen; i++) { // index 와 i의 시작점을 다르게 해준다.
            /*
            table = [ 0 ] [ 0 ] [ 1 ] [ 0 ] [ 1 ] [ 1 ] [ 2 ] [ 3 ]   [ 2 ]
                      0     1     2     3     4     5     6     7       8
                      A	    B     A     C     A     A     B     A       B
            * index가 0보다 크다는 것은 접두, 접미사 관계가 있었다는 것
            * 하지만 index에 위치한 문자와 i에 위치한 문자가 다르면, 더이상 같지 않다는 것이다.
            * 위 예시에서 마지막 문자 B를 상상해보자.
            * 그 동안(ABA) 반복되던 패턴의 끝 table[2]로 간다.
            * table 2에서는 하나가 반복되고 있단 의미의 1이 저장되어 있다.
            * table[index] == table[i]가 B == B로 만족하게 되며 아래 반복문으로 넘어가게 된다.
            * */
            while(index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = table[index - 1];
            }

            if(pattern.charAt(i) == pattern.charAt(index)) {
                index += 1; // 일치하는 문자가 있을 때 index는 증가한다.
                table[i] = index;
            } // 만일 index에 위치한 문자와 i에 위치한 문자가 같으면 table[i]에 index를 넣어준다.
        }
    }
}
