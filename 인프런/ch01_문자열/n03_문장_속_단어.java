package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n03_문장_속_단어 {

    public String solution(String str) {
        String answer = "";
        int max=0;
        for (String s : str.split(" ")) {
            if (max < s.length()) {
                max=s.length();
                answer = s;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        n03_문장_속_단어 t = new n03_문장_속_단어();
        System.out.println(t.solution(str));

    }
}
