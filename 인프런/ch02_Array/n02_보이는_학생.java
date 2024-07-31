package algorithm_private.인프런.ch02_Array;

import java.util.Scanner;

public class n02_보이는_학생 {
    public int solution(int[] arr) {
        int answer = 0;
        int max=0;
        for (int i = 0; i < arr.length ; i++) {
            if (max < arr[i]) {
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        n02_보이는_학생 t = new n02_보이는_학생();
        System.out.println(t.solution(arr));
    }
}
