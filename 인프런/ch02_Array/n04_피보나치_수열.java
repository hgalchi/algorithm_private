package algorithm_private.인프런.ch02_Array;

import java.util.Scanner;

public class n04_피보나치_수열 {
    String answer = "1";
    int p = 0;
    public String solution(int n) {
        if (p < n) {
            return answer;
        }
        return p+solution(p + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n04_피보나치_수열 t = new n04_피보나치_수열();
        System.out.println(t.solution(n));
    }
}
