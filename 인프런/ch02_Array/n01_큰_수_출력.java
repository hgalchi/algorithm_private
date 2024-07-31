package algorithm_private.인프런.ch02_Array;

import java.util.ArrayList;
import java.util.Scanner;

public class n01_큰_수_출력 {

    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        n01_큰_수_출력 t = new n01_큰_수_출력();
        System.out.println(t.solution(arr));


    }
}
