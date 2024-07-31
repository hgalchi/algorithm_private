package algorithm_private.인프런.ch03_TwoPointers_windowSliding;

import java.util.Scanner;

public class n05_연속된_자연수의_합 {
    public int solution(int n) {
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        int lt = 0, rt = 0, sum = 0, answer = 0;

        while (rt < n) {
            sum += arr[rt++];
            if(sum==n) answer++;
            else{
                while (sum > n) {
                    sum -= arr[lt++];
                    if(sum==n) answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n05_연속된_자연수의_합 t = new n05_연속된_자연수의_합();
        System.out.println(t.solution(n));
    }
}
