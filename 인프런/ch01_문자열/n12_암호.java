package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n12_암호 {
    public String solution(int x,String str) {
        String answer = "";
        for (int i = 0; i < x; i++) {
            String arr = str.substring(0, 7).replace('#', '1').replace('*', '0');
            //2진수를 10진수로 변환
            int num = Integer.parseInt(arr, 2);
            //아스키코드를 문자로 변환
            answer += (char) num;
            str=str.substring(7);

        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String str = sc.next();
        n12_암호 t = new n12_암호();
        System.out.println(t.solution(x, str));
    }
}
