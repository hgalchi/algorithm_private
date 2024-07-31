package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n06_중복문자_제거 {

    public String solution(String str) {
        String answer = "";

        for(int i=0;i<str.length();i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        n06_중복문자_제거 t = new n06_중복문자_제거();
        System.out.println(t.solution(str));
    }
}
