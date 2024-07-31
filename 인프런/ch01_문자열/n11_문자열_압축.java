package algorithm_private.인프런.ch01_문자열;

import java.util.Scanner;

public class n11_문자열_압축 {
    public String solution(String str) {
        String answer = "";
        int p=1;
        str+= " ";
        int size=str.length();

        for (int i = 0; i < str.length()-1; i++) {
            //다음 문자와 처음나오는 위치가 같다면 p++
            if (str.indexOf(str.charAt(i)) == str.indexOf(str.charAt(i + 1))) {
                p++;
                //다음 문자와 중복되는 문자가 아니라면 문자와 중복개수를 추가하고 p를 초기화
            }else{
                if (p != 1) {
                answer+=str.charAt(i)+String.valueOf(p);
                p=1;
                }else answer+=str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        n11_문자열_압축 t = new n11_문자열_압축();
        System.out.println(t.solution(str));
    }
}
