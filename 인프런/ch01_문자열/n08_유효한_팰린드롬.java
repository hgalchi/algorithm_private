package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n08_유효한_팰린드롬 {

    public String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String x = new StringBuilder(str).reverse().toString();
        if (!str.equals(x)) answer = "NO";
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        n08_유효한_팰린드롬 t = new n08_유효한_팰린드롬();
        System.out.println(t.solution(str));
    }
}
