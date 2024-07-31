package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n02_대소문자_변환 {

    String Solution(String str) {

        String answer = "";
        for (char x : str.toCharArray()) {
            //c = Character.isLowerCase(x) ? Character.toUpperCase(x) : Character.toLowerCase(x);
            if (x >= 97 && x <= 122) {
                answer += (char) (x - 32);
            } else answer += (char) (x + 32);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new n02_대소문자_변환().Solution(str));

    }
}
