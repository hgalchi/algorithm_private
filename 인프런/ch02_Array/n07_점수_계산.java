package algorithm_private.인프런.ch02_Array;

import java.util.Scanner;

public class n07_점수_계산 {

    public int solution(int[] arr) {
        int answer = 0, p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                p++;
            }else {
                p = 0;
            }
                answer += p;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        n07_점수_계산 t = new n07_점수_계산();
        System.out.println(t.solution(arr));
    }
}
