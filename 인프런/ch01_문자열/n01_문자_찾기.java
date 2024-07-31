package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;


public class n01_문자_찾기 {
    public int Solution(String word, char c) {
        int answer = 0;
        //word와 c모두 대문자로 변환
        word = word.toUpperCase();
        c = Character.toUpperCase(c);
        //반복문으로 word의 배열을 하나씩 c와 비교해 answer값을 늘린다.
        for (char s : word.toCharArray()) {
            if (s == c) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        n01_문자_찾기 T = new n01_문자_찾기();
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char c = sc.next().charAt(0);
        int result = T.Solution(word, c);
        System.out.println(result);
    }
}
