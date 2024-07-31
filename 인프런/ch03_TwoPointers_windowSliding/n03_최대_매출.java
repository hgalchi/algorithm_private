package algorithm_private.인프런.ch03_TwoPointers_windowSliding;

import java.util.Scanner;

public class n03_최대_매출 {
    public int solution(int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        answer = sum;
        for (int i = m; i < arr.length; i++) {
            sum += arr[i] - arr[i - m];
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        n03_최대_매출 t = new n03_최대_매출();
        System.out.println(t.solution(m, arr));
    }
}
