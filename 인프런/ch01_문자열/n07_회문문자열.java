package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n07_회문문자열 {
    public String solution(String str) {
        int lt = 0, rt = str.length() - 1;
        char[] ch = str.toUpperCase().toCharArray();
        while (lt < rt) {
            if (ch[lt] != ch[rt]) {
                return "NO";
            }
            lt++;
            rt--;
        }return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        n07_회문문자열 t = new n07_회문문자열();
        System.out.println(t.solution(str));
    }
}
