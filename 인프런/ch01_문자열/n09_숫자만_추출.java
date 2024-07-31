package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n09_숫자만_추출 {

    public int solution(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c <= 57 && c >= 48) {
                answer =(answer*10) + c - 48;
            }
        } return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        n09_숫자만_추출 t = new n09_숫자만_추출();
        System.out.println(t.solution(str));

    }
}
