package algorithm_private.인프런.ch01_문자열;

import java.util.Arrays;
import java.util.Scanner;

public class n10_문자거리 {

    public String solution(String str,char x) {
        int p=100;
        int[] list = new int[str.length()];
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] != x) {
                p++;
            } else p = 0;
            list[i] = p;
        }
        p=100;
        for (int i = str.length() - 1; i >= 0; i--) {
            //x가 아닌경우 p증가시킨 후 비교
            if (arr[i] != x){
                list[i] = Math.min(list[i], p++);
            }
            //x인 경우 p=0으로 초기화
            else{
                p = 0;
            }

        }
        System .out.println(Arrays.toString(list));
        return "test";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String x = sc.next();
        n10_문자거리 t = new n10_문자거리();
        System.out.println(t.solution(str,x.charAt(0)));
    }
}
