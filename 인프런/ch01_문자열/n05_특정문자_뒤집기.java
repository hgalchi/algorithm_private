package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n05_특정문자_뒤집기 {

    public String solution(String str) {
        int lt = 0, rt = str.length() - 1;
        char[] list = str.toCharArray();
        while (lt < rt) {
            if(!Character.isAlphabetic(list[lt])){
                lt++;
            } else if (!Character.isAlphabetic(list[rt])) {
                rt--;
            }else{
                char temp = list[lt];
                list[lt] = list[rt];
                list[rt] = temp;
                lt++;
                rt--;
            }
        }
        String answer = String.valueOf(list);
        return answer;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        n05_특정문자_뒤집기 t = new n05_특정문자_뒤집기();
        System.out.println(t.solution(str));
    }
}