package algorithm_private.인프런.ch02_Array;

import java.util.Scanner;

public class n05_소수 {
    public int solution(int n) {
        int[] arr = new int[n];
        int answer = 0;
        //2부터 시작 소수이기 때문에
        for (int i = 2; i < n; i++) {
            //소수일 경우
            if (arr[i - 2] != 1) {
                answer++;
                //소수로 나누어지는 값들을 1로 처리
                for (int j = i; j < n; j +=i) {
                    arr[j-2] = 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n05_소수 t = new n05_소수();
        System.out.println(t.solution(n));
    }
}
