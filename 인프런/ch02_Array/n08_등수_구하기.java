package algorithm_private.인프런.ch02_Array;

import java.util.Arrays;
import java.util.Scanner;

public class n08_등수_구하기 {

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                //점수가 더 낮을 때
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        n08_등수_구하기 t = new n08_등수_구하기();
        Arrays.stream(t.solution(arr)).forEach(s-> System.out.print(s+" "));
}
    }
